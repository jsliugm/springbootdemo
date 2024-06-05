package com.universe.demo.springboot.utils;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.Consts;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.concurrent.FutureCallback;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClients;
import org.apache.http.impl.nio.conn.PoolingNHttpClientConnectionManager;
import org.apache.http.impl.nio.reactor.DefaultConnectingIOReactor;
import org.apache.http.nio.NHttpClientConnection;
import org.apache.http.nio.reactor.IOReactorException;
import org.apache.http.util.EntityUtils;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@Slf4j
public class AsyncHttpClient {
    private static CloseableHttpAsyncClient createClient() throws IOReactorException {
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(500)
                .setSocketTimeout(1000)
                .setConnectionRequestTimeout(500)
                .build();
        PoolingNHttpClientConnectionManager cm = new PoolingNHttpClientConnectionManager(new DefaultConnectingIOReactor()){
            @Override
            public Future<NHttpClientConnection> requestConnection(HttpRoute route, Object state, long connectTimeout, long leaseTimeout, TimeUnit tunit, FutureCallback<NHttpClientConnection> callback) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return super.requestConnection(route, state, connectTimeout, leaseTimeout, tunit, callback);
            }

            @Override
            public void releaseConnection(NHttpClientConnection managedConn, Object state, long keepalive, TimeUnit tunit) {
                super.releaseConnection(managedConn, state, keepalive, tunit);
            }
        };
        CloseableHttpAsyncClient httpAsyncClient = HttpAsyncClients.custom().setDefaultRequestConfig(requestConfig).setConnectionManager(cm).build();
        return httpAsyncClient;
    }

    public static Map<String, String> post(Collection<String> urlList, String requestBody) {
        if (CollectionUtils.isEmpty(urlList)) {
            return Collections.emptyMap();
        }
        Map<String, String> resultMap = new ConcurrentHashMap<>();
        try (CloseableHttpAsyncClient client = createClient()) {
            client.start();
            final CountDownLatch latch = new CountDownLatch(urlList.size());
            for (String url : urlList) {
                HttpPost httpPost = new HttpPost(url);
                httpPost.setHeader("Content-Type", "application/json; charset=utf-8");
                StringEntity entity = new StringEntity(requestBody, ContentType.APPLICATION_JSON);
                httpPost.setEntity(entity);
                client.execute(httpPost, new FutureCallback<HttpResponse>() {
                    @Override
                    public void completed(HttpResponse result) {
                        log.info("completed");
//                        try {
//                            String response = getResponse(result);
//                            resultMap.put(url, response);
//                        } catch (Exception e) {
//                            log.error("", e);
//                        }
                        latch.countDown();
                    }

                    @Override
                    public void failed(Exception ex) {
                        log.error("failed", ex);
                        latch.countDown();
                    }

                    @Override
                    public void cancelled() {
                        log.info("cancelled");
                        latch.countDown();
                    }
                });
            }
            latch.await();
        } catch (Exception e) {
            log.error("url:{} requestBody: {}", urlList, requestBody, e);
        }
        return resultMap;
    }

    private static String getResponse(HttpResponse result) throws Exception {
        if (result == null || result.getEntity() == null) {
            return null;
        }
        return EntityUtils.toString(result.getEntity(), Consts.UTF_8);
    }

    public static void main(String[] args) {
        List<String> urlList = Lists.newArrayList("http://127.0.0.1:31001/sbd/http/test");
        Map<String, String> map = post(urlList, "");
        for (int i = 0; i < 10000; i++) {
            post(urlList,"");
        }
    }
}

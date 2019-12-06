package com.yeelee.TD;

import org.apache.http.client.HttpClient;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.ssl.SSLContextBuilder;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

@SpringBootApplication
@MapperScan("com.yeelee.TD.mapper")
@EnableTransactionManagement //开启事物
@EnableScheduling
public class TdApplication {
	private static Logger logger = LoggerFactory.getLogger(TdApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(TdApplication.class, args);
		logger.info("========================启动成功==============================");
	}

//	@Bean
//	public RestTemplate customRestTemplate(){
//		HttpComponentsClientHttpRequestFactory httpRequestFactory = new HttpComponentsClientHttpRequestFactory();
//		httpRequestFactory.setConnectionRequestTimeout(554200);
//		httpRequestFactory.setConnectTimeout(555000);
//		httpRequestFactory.setReadTimeout(455500);
//
//		return new RestTemplate(httpRequestFactory);
//	}


	//解决跨域问题
	@Bean
	public CorsFilter corsFilter() {
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		final CorsConfiguration config = new CorsConfiguration();
		// 允许cookies跨域
		config.setAllowCredentials(true);
		// 允许向该服务器提交请求的URI，*表示全部允许，在SpringMVC中，如果设成*，会自动转成当前请求头中的Origin
		config.addAllowedOrigin("*");
		// 允许访问的头信息,*表示全部
		config.addAllowedHeader("*");
		// 预检请求的缓存时间（秒），即在这个时间段里，对于相同的跨域请求不会再预检了
		config.setMaxAge(18000L);
		// 允许提交请求的方法，*表示全部允许
		config.addAllowedMethod("OPTIONS");
		config.addAllowedMethod("HEAD");
		// 允许Get的请求方法
		config.addAllowedMethod("GET");
		config.addAllowedMethod("PUT");
		config.addAllowedMethod("POST");
		config.addAllowedMethod("DELETE");
		config.addAllowedMethod("PATCH");
		source.registerCorsConfiguration("/**", config);
		return new CorsFilter(source);
	}

	@Bean
	public RestTemplate restTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setRequestFactory(clientHttpRequestFactory());
		restTemplate.setErrorHandler(new DefaultResponseErrorHandler());
		return restTemplate;
	}
	@Bean
	public HttpComponentsClientHttpRequestFactory clientHttpRequestFactory() {
		try {
			HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
			SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {
				public boolean isTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
					return true;
				}
			}).build();
			httpClientBuilder.setSSLContext(sslContext);
			HostnameVerifier hostnameVerifier = NoopHostnameVerifier.INSTANCE;
			SSLConnectionSocketFactory sslConnectionSocketFactory = new SSLConnectionSocketFactory(sslContext, hostnameVerifier);
			Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
					.register("http", PlainConnectionSocketFactory.getSocketFactory())
					.register("https", sslConnectionSocketFactory).build();// 注册http和https请求
			// 开始设置连接池
			PoolingHttpClientConnectionManager poolingHttpClientConnectionManager = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
			poolingHttpClientConnectionManager.setMaxTotal(500); // 最大连接数500
			poolingHttpClientConnectionManager.setDefaultMaxPerRoute(100); // 同路由并发数100
			httpClientBuilder.setConnectionManager(poolingHttpClientConnectionManager);
			httpClientBuilder.setRetryHandler(new DefaultHttpRequestRetryHandler(3, true)); // 重试次数
			HttpClient httpClient = httpClientBuilder.build();
			HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory(httpClient); // httpClient连接配置
			clientHttpRequestFactory.setConnectTimeout(20000);              // 连接超时
			clientHttpRequestFactory.setReadTimeout(30000);                 // 数据读取超时时间
			clientHttpRequestFactory.setConnectionRequestTimeout(20000);    // 连接不够用的等待时间
			return clientHttpRequestFactory;
		} catch (KeyManagementException | NoSuchAlgorithmException | KeyStoreException e) {
			logger.error("初始化HTTP连接池出错", e);
		}
		return null;
	}
}

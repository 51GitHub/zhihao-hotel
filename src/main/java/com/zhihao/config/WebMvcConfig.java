/*
package com.zhihao.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.ArrayList;
import java.util.List;

*/
/**
 * Created by HT on 2017/12/5.
 *//*

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
FastJsonConfig fastJsonConfig = new FastJsonConfig();
fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
//处理中文乱码问题
List<MediaType> fastMediaTypes = new ArrayList<>();
fastMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
fastConverter.setSupportedMediaTypes(fastMediaTypes);
fastConverter.setFastJsonConfig(fastJsonConfig);
converters.add(fastConverter);
}

}
*/

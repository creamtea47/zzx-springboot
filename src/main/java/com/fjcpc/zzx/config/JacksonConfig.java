package com.fjcpc.zzx.config;

/*** 1.4 jackson 中对null的处理
 * @author xiaolu LuAng
 * @create 2022-05-29 12:00
 **/
//@Configuration
//public class JacksonConfig {
//    @Bean
//    @Primary
//    @ConditionalOnMissingBean(ObjectMapper.class)
//    public ObjectMapper jacksonObjectMapper(Jackson2ObjectMapperBuilder builder) {
//        ObjectMapper objectMapper = builder.createXmlMapper(false).build();
//        objectMapper.getSerializerProvider().setNullValueSerializer(new JsonSerializer<Object>() {
//            @Override
//            public void serialize(Object o, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
//                // TODO: 2022/5/29 重写方法，让返回的null变为""
//                jsonGenerator.writeString("");
//            }
//        });
//        return objectMapper;
//    }
//
//}
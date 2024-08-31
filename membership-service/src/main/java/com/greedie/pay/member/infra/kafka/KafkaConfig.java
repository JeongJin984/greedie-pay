package com.greedie.pay.member.infra.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
@EnableKafka
public class KafkaConfig {
    @Bean
    public NewTopic testTopic() {
        return TopicBuilder.name("test-topic")
                .partitions(1)
                .replicas(1)
                .build();
    }

    @Bean
    public NewTopic memberMoneyRegisterTopic() {
        return TopicBuilder.name("member-signup-initialize")
                .partitions(1)
                .replicas(1)
                .build();
    }
}

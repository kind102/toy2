package com.ateam.domain.common.config

import com.mongodb.reactivestreams.client.MongoClient
import com.mongodb.reactivestreams.client.MongoClients
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration
import org.springframework.data.mongodb.core.convert.MongoCustomConversions
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories

@Configuration
@EnableReactiveMongoRepositories(
    basePackages = ["com.ateam.domain"]
)
class MongodbConfiguration : AbstractReactiveMongoConfiguration() {

    override fun getDatabaseName() = "a-team"

    override fun reactiveMongoClient(): MongoClient = mongoClient()

    /*override fun reactiveMongoTemplate(
        databaseFactory: ReactiveMongoDatabaseFactory,
        mongoConverter: MappingMongoConverter
    ): ReactiveMongoTemplate {
        //return super.reactiveMongoTemplate(databaseFactory, mongoConverter)
        return ReactiveMongoTemplate(mongoClient(), databaseName);
    }*/

   /* override fun customConversions(): MongoCustomConversions {
        converters.add(UserWriterConverter())
        return MongoCustomConversions(converters)
    }*/

    @Bean
    fun mongoClient() = MongoClients.create()
}

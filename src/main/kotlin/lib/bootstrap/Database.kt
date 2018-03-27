package lib.bootstrap

import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.StdOutSqlLogger
import org.jetbrains.exposed.sql.transactions.transaction
import java.io.File
import java.sql.Connection

fun databaseSetup(): Unit {
    Database.connect("jdbc:sqlite:${File("src/resources/database.sqlite").absolutePath}", "org.sqlite.JDBC")
    transaction(transactionIsolation = Connection.TRANSACTION_SERIALIZABLE, repetitionAttempts = 3) {
        logger.addLogger(StdOutSqlLogger)
    }
}
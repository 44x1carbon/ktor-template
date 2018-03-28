package lib.bootstrap

import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction
import java.io.File
import java.sql.Connection

fun databaseSetup(): Unit {
    Database.connect("jdbc:sqlite:${File("src/main/resources/database.sqlite").absolutePath}", "org.sqlite.JDBC")
    transactionSQLite {
        logger.addLogger(StdOutSqlLogger)
    }
}

fun Table.createTable() {
    transactionSQLite {
        SchemaUtils.create(this@createTable)
    }
}

fun <T> transactionSQLite(block: Transaction.() -> T): T {
    return transaction(transactionIsolation = Connection.TRANSACTION_SERIALIZABLE, repetitionAttempts = 3) {
        block()
    }
}
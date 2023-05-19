package com.miguelmariguin.tickets.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.miguelmariguin.tickets.preload.LoadMockData;

@RestController
public class TruncateController {

    private final DataSource dataSource;
    @Autowired
	LoadMockData loadMockData;
    
    @Autowired
    public TruncateController(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @GetMapping("/reset")
    public ResponseEntity<String> truncateTables() throws ParseException {
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate("SET REFERENTIAL_INTEGRITY FALSE");

            statement.executeUpdate("TRUNCATE TABLE TBL_BUTACA");
            statement.executeUpdate("TRUNCATE TABLE TBL_DISPONIBILIDAD");
            statement.executeUpdate("TRUNCATE TABLE TBL_FUNCION");
            statement.executeUpdate("TRUNCATE TABLE TBL_LUGAR");
            statement.executeUpdate("TRUNCATE TABLE TBL_RESERVA");
            statement.executeUpdate("TRUNCATE TABLE TBL_SALA");
            statement.executeUpdate("TRUNCATE TABLE TBL_SHOW");

            statement.executeUpdate("SET REFERENTIAL_INTEGRITY TRUE");
        } catch (SQLException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error truncating tables: " + e.getMessage());
        }
       
        loadMockData.loadData();
        return ResponseEntity.ok("Tables truncated successfully");
    }
}


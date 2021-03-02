package main;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClientTest {

    @Test
    void getId() {
        Client c = new Client();
        c.setId("Test ID");
        assertEquals("Test ID", c.getId());
    }

    @Test
    void getClientPort() {
        Client c = new Client();
        c.setClientPort("55");
        assertEquals(55, c.getClientPort());
    }

    @Test
    void getClientIP() {
        Client c = new Client();
        c.setClientIP("localhost");
        assertEquals("localhost", c.getClientIP());

    }

    @Test
    void getServerPort() {
        Client c = new Client();
        c.setServerPort("1234");
        assertEquals(1234, c.getServerPort());
    }

    @Test
    void getServerIPAddress() {
        Client c = new Client();
        c.setServerIPAddress("127.0.0.1");
        assertEquals("127.0.0.1", c.getServerIPAddress());
    }
}
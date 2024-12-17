package example;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Server {

    private static final Logger log = LoggerFactory.getLogger(Server.class);

    public static void main(String[] args) throws IOException {
        try (
                final var serverSocketChannel = ServerSocketChannel.open()
                        .bind(new InetSocketAddress(8081));
                final var socketChannel = serverSocketChannel.accept()
        ) {
            log.info("connect: {}", socketChannel);
        }
    }
}

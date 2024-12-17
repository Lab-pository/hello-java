package example;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;

public class Client {

    public static void main(String[] args) throws IOException {
        try (final SocketChannel socketChannel = SocketChannel.open()
                .bind(new InetSocketAddress(8080))) {
            socketChannel.connect(new InetSocketAddress(8081));
        }
    }
}

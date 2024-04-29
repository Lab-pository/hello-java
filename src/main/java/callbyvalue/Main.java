package callbyvalue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        Node ten = new Node(10);
        Node one = new Node(1);

        convertDirectly(ten, 10);
        convertNew(one, 100);

        log.info("convertDirectly : {}", ten.getValue()); // 100
        log.info("convertNew : {}", one.getValue()); // 1
    }

    static void convertDirectly(Node node, int mul) {
        int nowValue = node.getValue();
        node.setValue(nowValue * mul);
    }

    static void convertNew(Node node, int mul) {
        int nowValue = node.getValue();
        node = new Node(nowValue * mul);
    }
}

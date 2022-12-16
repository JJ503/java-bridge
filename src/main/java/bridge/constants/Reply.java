package bridge.constants;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Reply {
    RETRY("R"),
    STOP("Q");

    private static final Map<String, Reply> RETRY_BY_MARK = Stream.of(values())
            .collect(Collectors.toMap(Reply::getReply, Function.identity()));

    private final String reply;

    Reply(String reply) {
        this.reply = reply;
    }

    private String getReply() {
        return reply;
    }

    private static Reply getReply(String reply) {
        return RETRY_BY_MARK.get(reply);
    }
}

package bridge.constants;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Reply {
    RETRY("R", true),
    STOP("Q", false);

    private static final Map<String, Boolean> RETRY_BY_MARK = Stream.of(values())
            .collect(Collectors.toMap(Reply::getReply, Reply::getReplyState));

    private final String reply;
    private final boolean retryState;

    Reply(String reply, boolean retryState) {
        this.reply = reply;
        this.retryState = retryState;
    }

    private String getReply() {
        return reply;
    }

    private boolean getReplyState() {
        return retryState;
    }

    public static boolean getReply(String reply) {
        return RETRY_BY_MARK.get(reply);
    }
}

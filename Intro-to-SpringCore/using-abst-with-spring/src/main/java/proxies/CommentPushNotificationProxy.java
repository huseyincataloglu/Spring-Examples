package proxies;

import model.Comment;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Qualifier("Push") // Defining bean neame when using stereotype annotations
public class CommentPushNotificationProxy implements CommentNotificationProxy{
    @Override
    public void sendComment (Comment comment) {
        System.out.println(
                "Sending push notification for comment:"
                        + comment.getText());
    }
}

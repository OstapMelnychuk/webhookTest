package com.example.webhook.responce;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class FileCommentWebhookResponse {
    private Comment[] comment;
    private String comment_id;
    private String created_at;
    private String event_type;
    private String file_key;
    private String file_name;
    private String[] mentions;
    private String order_id;
    private String parent_id;
    private String passcode;
    private String protocol_version;
    private String resolved_at;
    private String retries;
    private String timestamp;
    private User triggered_by;
    private String webhook_id;
}

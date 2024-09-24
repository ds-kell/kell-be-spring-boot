package vn.com.dsk.demo.base.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailDetails {
    /**
     * Attachment paths use "/" not "\"
     * */
    private String recipient;
    private String msgBody;
    private String subject;
    private String attachment;
}
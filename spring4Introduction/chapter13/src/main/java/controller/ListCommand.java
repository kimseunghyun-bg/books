package controller;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * @author Seunghyun Kim
 * @since 2020-04-07
 */
public class ListCommand {

    @Getter
    @Setter
    @DateTimeFormat(pattern = "yyyyMMddHH")
    private LocalDateTime from;
    @Getter
    @Setter
    @DateTimeFormat(pattern = "yyyyMMddHH")
    private LocalDateTime to;

}

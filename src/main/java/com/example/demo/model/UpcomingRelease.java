package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.w3c.dom.stylesheets.LinkStyle;

import javax.persistence.*;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
public class UpcomingRelease {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long upcomingReleaseId;
    @OneToMany
    private List<Book> bookId;
}

package greet.greetingservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "book")
@Data
@AllArgsConstructor
public class Book {

  @Id
  private String isbn ;
  private String author ;
  private Double price ;
  private String title ;

}

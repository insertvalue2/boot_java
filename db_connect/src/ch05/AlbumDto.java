package ch05;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AlbumDto {
	private int albumId; 
	private String songWriter; 
	private String songTitle;  
}

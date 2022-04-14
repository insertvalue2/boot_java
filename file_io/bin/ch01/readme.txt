	** 입출력 스트림 ** 
	
	네트워크에서 자료의 흐름을 물의 흐름과 같다는 비유에서 유래 
	자바는 다양한 입출력 장치에 독릭접으로 일관성있는 입출력 스트림을 제공
	입출력이 구현되는 곳 : 파일 디스트, 키보드, 네티워크, 메모리 등 모든 자료가 입력되고 출력 되는 곳
		
	** 입출력 스트림의 구분 ** 
	
	대상 기분 : 입력 스트림 / 출력 스트림 
	자료의 종료 : 바이트 스트림 / 문자 스트림 
	기능 : 기반 스트림 / 보조 스트림 
	
	** 입출력 스트림의 종류 ** 
	
	입력 스트림 : FileInputStream, FileReader, BufferedInputStream, BufferedReader 등 
	출력 스트림 : FileOutputStream, FileWriter, BufferedOutputStream, BufferedWriter 등
	
	
	** 바이트 단위 스트림과 문자 단위 스트림 **
	바이트 단위 스트림 : 동영상, 음악 파일, 실행 파일등의 자료를 읽고 쓸 때 사용 
	문자 단위 스트림 : 바이트 단위로 자료를 처리하면 문자는 깨짐, 인코딩에 맞게 2바이트 이상으로 처리하도록 구현된 스트림 
	
    0 0 0 0 0 0  : 1byte 	 
	
	00 00 00 00 00 00 : 2byte 
	
	
	** 바이트/문자 단위 스트림의 종류 ** 
	바이트 단위 : FileInputStream, FileOutputStream, BufferedInputStream, BufferedOutputStream 등 
	문자 단위 : FileReader, FileWrite, BufferedReader, BufferedWriter 등 
	
	
	** 기반 스트림과 보조 스트림 ** 
	기반 스트림 : 대상에 직접 자료을 읽어 들이거나 쓰는 기능을 가지고 있다. (바이트, 문자) 
    보조 스트림 : 직접 읽고 쓰는 기능은 없고 추가적인 기능을 더해주는 스트림 
    참고 : 보조 스트림은 직접 읽고 쓰는 기능이 없기 때문에 기반 스트림의 생성자 매개 변수로 포함해서 사용한다. 
    
    기반 스트림 + 보조스트림A + 보조스트림B 
    
    기반/보조 스트림의 종류 
    기반 스트림 : FileInputStream, FileOutputStream, FileWriter 등 
    보조 스트림 : InputStreamReader, OutputStreamWriter, BufferedInputStream BufferedOutputStream 등 
    
    
    
    
    
    
    
    
    	 
	
	
	
	
	
	
	
	 
	 
	
	
	
	
	
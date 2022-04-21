package ch02;

/**
 * 
 * @author tenco
 * 두 수중에 큰 수를 반환 하는 기능 
 * 
 */
@FunctionalInterface
public interface IMaxNumber {
	int getMax(int a, int b);
}

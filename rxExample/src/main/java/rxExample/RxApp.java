package rxExample;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.*;

public class RxApp {

	public static void main(String[] args) {
		
		Flowable.range(1, 75)
		  .skip(10)
		  .take(5)
		  .map(v -> "this is my mapped taken element"+ v)
		  .subscribe(System.out::println);

		Flowable.fromArray("a","a","c")
		.distinct()
		.map(v -> "*" + v)
		.subscribe(System.out::println);
		



		
	
	}

}
	
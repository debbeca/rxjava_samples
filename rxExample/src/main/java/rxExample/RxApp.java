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
		


Single<List<Todo>> todosSingle = Single.create(emitter -> {
        Thread thread = new Thread(() -> {
                try {
                        List<Todo> todosFromWeb = new ArrayList<Todo>(); // query a webservice

                        System.out.println("Called 4 times!");

                        emitter.onSuccess(todosFromWeb);
                } catch (Exception e) {
                        emitter.onError(e);
                }
        });
        thread.start();
});


System.out.println("todo in graph");
todosSingle.subscribe(System.out::println );

//showTodosInATable(todosSingle);
System.out.println("todo in single");

todosSingle.subscribe( System.out::println );
System.out.println("todo in gant");

todosSingle.cache();

//anotherMethodThatsSupposedToSubscribeTheSameSingle(todosSingle);


		
	
	}

}
	
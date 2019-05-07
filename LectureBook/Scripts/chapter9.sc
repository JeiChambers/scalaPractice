//import java.io.File
//
//import com.sun.java.util.jar.pack.Package.File
//
//private def filesHere = (new java.io.File(".")).listFiles
//private def filesMatching(matcher: String => Boolean )=
//  for (file <- filesHere){
//    if matcher(file.getName))
//    yield file
//def filesEnding(query: String):Boolean =
//  filesMatching( _.endswith(query) )
//  }
//def filesContaining(query: String) =
//  filesMatching(_.contains(query))
//def filesRegex(query: String) =
//  filesMatching(_.matches(query))
//
//
//
//def curriedSum(x:Int)(y:Int): Int = x + y
//
//curriedSum(1)(2)
//
////Partially applied function expression
//val onePlus = curriedSum(1)_
//
//// In languages with FCF you can make new control structures by
//// creating methods that take functions as arguments.
//def twice(op: Double => Double, x: Double) = op(op(x))
//
//def withPrintWriter(file: File, op: PrintWriter => Unit): Unit ={
//  val writer = new PrintWriter(file)
//  try {
//    op(writer)
//  }finally {
//   writer.close()
//  }
//}
//
//withPrintWriter(
//  new File("date.txt"),
//  writer => writer.println(new java.util.Date)
//)
//
////9.5 By-name Parameters
//withPrintWriter(file){ writer =>
//  writer.println(new java.util.Date)
//}
//
//// 1...2...3..Not it! V
//var assertionsEnabled = true
//
//def myAssert(predicate: () => Boolean) =
//  if (assertionsEnabled &&  ! predicate())
//    throw new AssertionError
//
//myAssert(() => 5 > 3)
////myAssert(5 > 3 ) Won't Compile because () => is missing <.<
//
//
//def byNameAssert(predicate: => Boolean ) =
//  if (assertionsEnabled && !predicate)
//    throw new AssertionError
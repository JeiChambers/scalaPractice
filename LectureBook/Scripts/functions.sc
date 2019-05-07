//import java.io.File
//import scala.io.Source
//import scala.annotation.tailrec
//
//// Prog in Scala Reading Files
//object LongLines{
//
//  def processFile(filename: String, width: Int) = {
//    val source = Source.fromFile(filename)
//    for (line <- source.getLines())
//      processLine(filename, width, line)
//  }
//
//  private def processLine(filename: String, width: Int, line: String) = {
//    if(line.length > width)
//      println(filename + ":" + line.trim)
//  }
//}
//
//
//
//
//def fileContainsQuestion(file: File): Boolean = {
//  val source = Source.fromFile(file)
//
//  try {
//    source.getLines().toSeq.headOption.exists { line =>
//      line.trim.endsWith("?")
//    }.getOrElse("")
//  } finally source.close()
//}
//
////Stairway to Scala Using File Contents
//val projectDir = "/Users/JChambers/Desktop/ScalaProjects/scalaPractice/Lecture and Book/text_files/"
//
//val fileLoc = new File(projectDir)
//
//for(name <- Seq("Beowulf_Snippet.txt")) {
//  val file = new File(fileLoc, name)
//  println(s"$name ${fileContainsQuestion(file)}")
//}
//
//def emphasizeFileContents(file: File): String = {
//  val source = Source.fromFile(file)
//
//  try{
//    source.getLines().toSeq.headOption.map { line =>
//      line.trim.toUpperCase
//    }.getOrElse("")
//  }finally source.close()
//}
//
//
//
//
//// Recursive "while loop" & By name functions
//@tailrec
//def funkloop(pred: () => Boolean)(body: () => Unit): Unit = {
//  if(pred){
//    body()
//    funkloop(pred)(body)
//  }
//}
//
//// Without syntactic sugar
//var x = 0
//funkloop(() => x < 5){ () =>
//  println(x * x)
//  x +=1
//}
//
//// Candy
//var y = 0
//funkloop(y < 5){
//  println(y * y)
//  y += 1
//}
//
//// If using ByName functions for anythign other than recursion, covert them to Function0s ASAP.
//
//
//
//













}
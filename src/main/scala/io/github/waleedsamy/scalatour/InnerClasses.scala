package io.github.waleedsamy.scalatour

object InnerClasses extends App {

  class Graph {

    class Node {
      var connectedNodes: List[Node] = Nil

      def connectTo(n: Node) = {
        if (connectedNodes.find(n.equals).isEmpty)
          connectedNodes = n :: connectedNodes
      }
    }

    var nodes: List[Node] = Nil

    def addNode: Node = {
      val res = new Node
      nodes = res :: nodes
      res
    }
  }

  val g = new Graph
  val n1 = g.addNode
  val n2 = g.addNode
  val n3 = g.addNode
  n1.connectTo(n2)
  n2.connectTo(n3)

  val h = new Graph
  var m1 = h.addNode

  // won't compile
  //n1.connectTo(m1)

}

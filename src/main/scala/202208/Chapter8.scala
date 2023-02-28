package `202208`

object Chapter8 {

  /** EXERCISE 8.1
    *
    * テストをこのように考えることに慣れておくために、`sum: List[Int] => Int`関数の実装を指定するプロパティを考え出せ。
    * それらのプロパティを実行可能なScalaCheckコードとして記述する必要はなく、便宜的な説明でもよい。
    * 出発点として以下を参考にすること。
    *
    * ・リストをリバースしてから合計すると、元のリバースしていないリストを合計した場合と同じ結果になるはずである。
    * ・リストのすべての要素が同じ値である場合、合計はどうなるか。
    * ・他のプログラムを思いつけるか。
    */

  /** EXERCISE 8.2
    *
    * List[Int]の最大値を検出する関数を指定するプロパティはどのようなものになるか。
    */

  /** EXERCISE 8.3
    *
    * Propの表現が以下であると仮定して、&&をPropのメソッドとして実装せよ。
    *
    * trait Prop { def check: Boolean }
    */

  /** EXERCISE 8.4
    *
    * Genのこの表現を使って、startからstopExclusiveの範囲内の整数を生成するGen.chooseを実装せよ。
    * すでに記述してある関数を自由に使用してかまわない。
    *
    * def choose(start: Int, stopExclusive: Int): Gen[Int]
    */

  /** EXERCISE 8.5
    *
    * Genのこの表現を使って他に何を実装できるか。
    * 試しにunit、boolean、listOfNを実装せよ。
    * unitは常にaの値を生成し、listOfNはジェネレータgを使って長さnのリストを生成する。
    *
    * def unit[A](a: => A): Gen[A]
    * def boolean: Gen[Boolean]
    * def listOfN[A](n: Int, g: Gen[A]): Gen[List[A]]
    */

  /** EXERCISE 8.6
    *
    * flatMapを実装し、それを使ってもう少し動的なlistOfNを実装せよ。
    * flatMapとlistOfNはGenクラスに配置すること。
    *
    * def flatMap[B](f: A => Gen[B]): Gen[B]
    * def listOfN(size: Gen[Int]): Gen[List[A]]
    */

  /** EXERCISE 8.7
    *
    * 同じ型の2つのジェネレータを1つに結合するunionを実装せよ。
    * 結合は各ジェネレータから同じ値となる可能性があるものを取り出すという方法で行う。
    *
    * def union[A](g1: Gen[A], g2: Gen[A]): Gen[A]
    */

  /** EXERCISE 8.8
    *
    * unionの別バージョンとしてweightedを実装せよ。
    * weightedは、各Genから重みを受け取り、その重みに比例する確率で値を生成する。
    *
    * def weighted[A](g1: (Gen[A], Double), g2: (Gen[A], Double)): Gen[A]
    */

  /** EXERCISE 8.9
    *
    * Propの表現に基づき、Prop型の値を合成するための&&と||を実装せよ。
    * 失敗のケースでは、左右どちらかのプロパティが原因であるかわからない。
    * 失敗のケースで表示されるタグまたはラベルをProp型の値に割り当てられるようにするなど、これに対処する方法を考え出せるか。
    *
    * def &&(p: Prop): Prop
    * def ||(p: Prop): Prop
    */

  /** EXERCISE 8.10
    *
    * GenをSGenに変換するヘルパー関数を実装せよ。
    * これはGenのメソッドとして追加できる。
    *
    * def unsized: SGen[A]
    */

  /** EXERCISE 8.11
    *
    * 当然のことながら、SGenは少なくともGenと同じ演算の多くをサポートし、その実装はかなり機械的である。
    * Genの対応する関数にデリゲートするだけの便利な関数をSGenで定義せよ。
    */

  /** EXERCISE 8.12
    *
    * 明示的なサイズを受け取らないlistOfコンビネータを実装せよ。
    * この実装は、GenではなくSGenを返し、要求されたサイズのリストを生成する。
    *
    * def listOf[A](g: Gen[A]): SGen[List[A]]
    */

}

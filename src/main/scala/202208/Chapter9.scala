package `202208`

object Chapter9 {

  /** EXERCISE 9.1
    *
    * productを使ってコンビネータmap2を実装し、これを使って、manyをベースとしてmany1を実装せよ。
    * ここまでの章と同様に、map2をプリミティブにし、map2をベースとしてproductを定義することもできる。
    * どちらを選択するかはあなた次第である。
    *
    * def map2[A, B, C](p: Parser[A], p2: Parser[B])(f: (A, B) => C): Parser[C]
    */

  /** EXERCISE 9.2
    *
    * productの振る舞いを定義する法則を考え出せ。
    */

  /** EXERCISE 9.3
    *
    * 先へ進む前に、or、map2、succeedをベースとしてmanyを定義できるか検討せよ。
    */

  /** EXERCISE 9.4
    *
    * map2とsucceedを使って先のlistOfNコンビネータを実装せよ。
    *
    * def listOfN[A](n: Int, p: Parser[A]): Parser[List[A]]
    */

  /** EXERCISE 9.5
    *
    * 第7章で示したように、非正格性に別のコンビネータで対処することもできる。
    * ここでもそれを試して、既存のコンビネータに必要な変更を追加せよ。
    * このアプローチをここで試すことについてどう思うか。
    */
}

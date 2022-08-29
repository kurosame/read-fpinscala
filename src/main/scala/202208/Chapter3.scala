package `202208`

object Chapter3 {

  /** EXERCISE 3.1
    *
    * 以下のマッチ式`x`はどのような結果になるか。
    */
  // sealed trait List[+A]
  // case object Nil extends List[Nothing]
  // case class Cons[+A](h: A, t: List[A]) extends List[A]
  // object List {
  //   def sum(ints: List[Int]): Int = ints match {
  //     case Nil         => 0
  //     case Cons(x, xs) => x + sum(xs)
  //   }
  //   def apply[A](as: A*): List[A] =
  //     if (as.isEmpty) Nil
  //     else Cons(as.head, apply(as.tail: _*))
  // }

  // val x = List(1, 2, 3, 4, 5) match {
  //   case Cons(x, Cons(2, Cons(4, _)))          => x
  //   case Nil                                   => 42
  //   case Cons(x, Cons(y, Cons(3, Cons(4, _)))) => x + y
  //   case Cons(h, t)                            => h + List.sum(t)
  //   case _                                     => 101
  // }
  // 3
  // 正解
  // def main(args: Array[String]): Unit = {
  //   println(x) // 3
  // }

  /** EXERCISE 3.2
    *
    * Listの最初の要素を削除する関数tailを実装せよ。
    * この関数の実行時間が一定であることに注意。
    * ListがNilである場合、実装上の選択肢として他に何があるか。
    * この質問については、次章で再び取り上げる。
    *
    * def tail[A](l: List[A])
    */
  // sealed trait List[+A]
  // case object Nil extends List[Nothing]
  // case class Cons[+A](h: A, t: List[A]) extends List[A]
  // object List {
  //   def apply[A](as: A*): List[A] =
  //     if (as.isEmpty) Nil
  //     else Cons(as.head, apply(as.tail: _*))

  //   // EXERCISE 3.2
  //   def tail[A](l: List[A]) = l match {
  //     case Nil        => Nil
  //     case Cons(h, t) => t
  //   }
  // }

  // def main(args: Array[String]): Unit = {
  //   println(List.tail(List(1, 2, 3))) // Cons(2,Cons(3,Nil))
  //   println(List.tail(Nil)) // Nil
  //   println(List.tail(List(1))) // Nil
  // }
  // 正解

  /** EXERCISE 3.3
    *
    * EXERCISE 3.2と同じ考え方に基づいて、Listの最初の要素を別の値と置き換えるsetHead関数を実装せよ。
    *
    * def setHead[A](l: List[A], x: A): List[A]
    */
  // sealed trait List[+A]
  // case object Nil extends List[Nothing]
  // case class Cons[+A](h: A, t: List[A]) extends List[A]
  // object List {
  //   def apply[A](as: A*): List[A] =
  //     if (as.isEmpty) Nil
  //     else Cons(as.head, apply(as.tail: _*))

  //   // EXERCISE 3.3
  //   def setHead[A](l: List[A], x: A) = l match {
  //     case Nil        => Nil
  //     case Cons(h, t) => Cons(x, t)
  //   }
  // }

  // def main(args: Array[String]): Unit = {
  //   println(List.setHead(List(1, 2, 3), 4)) // Cons(4,Cons(2,Cons(3,Nil)))
  //   println(List.setHead(Nil, 4)) // Nil
  //   println(List.setHead(List(1), 4)) // Cons(4,Nil)
  // }
  // 正解

  /** EXERCISE 3.4
    *
    * tailを一般化して、リストの先頭からn個の要素を削除するdropという関数に置き換えよ。
    * この関数の実行時間は削除する要素の数にのみ比例することに注意。
    * List全体のコピーを作成する必要はない。
    *
    * def drop[A](l: List[A], n: Int): List[A]
    */
  // sealed trait List[+A]
  // case object Nil extends List[Nothing]
  // case class Cons[+A](h: A, t: List[A]) extends List[A]
  // object List {
  //   def apply[A](as: A*): List[A] =
  //     if (as.isEmpty) Nil
  //     else Cons(as.head, apply(as.tail: _*))

  //   // EXERCISE 3.4
  //   def drop[A](l: List[A], n: Int): List[A] = (l, n) match {
  //     case (_, 0)          => l
  //     case (Nil, _)        => Nil
  //     case (Cons(h, t), _) => drop(t, n - 1)
  //   }
  // }

  // def main(args: Array[String]): Unit = {
  //   println(List.drop(List(1, 2, 3), 1)) // Cons(2,Cons(3,Nil))
  //   println(List.drop(List(1, 2, 3), 2)) // Cons(3,Nil)
  //   println(List.drop(Nil, 1)) // Nil
  //   println(List.drop(List(1), 1)) // Nil
  // }
  // 正解

  /** EXERCISE 3.5
    *
    * 述語とマッチする場合に限り、Listからその要素までの要素を削除するdropWhileを実装せよ。
    *
    * def dropWhile[A](l: List[A], f: A => Boolean): List[A]
    */
  // sealed trait List[+A]
  // case object Nil extends List[Nothing]
  // case class Cons[+A](h: A, t: List[A]) extends List[A]
  // object List {
  //   def apply[A](as: A*): List[A] =
  //     if (as.isEmpty) Nil
  //     else Cons(as.head, apply(as.tail: _*))

  //   // EXERCISE 3.5
  //   def dropWhile[A](l: List[A], f: A => Boolean): List[A] = l match {
  //     case Cons(h, t) if f(h) => dropWhile(t, f)
  //     case _                  => l
  //   }
  // }

  // def main(args: Array[String]): Unit = {
  //   println(List.dropWhile(List(1, 2, 3), (x: Int) => x <= 1)) // Cons(2,Cons(3,Nil))
  //   println(List.dropWhile(List(1, 2, 3), (x: Int) => x <= 2)) // Cons(3,Nil)
  //   println(List.dropWhile(Nil, (x: Int) => x <= 1)) // Nil
  //   println(List.dropWhile(List(1), (x: Int) => x <= 1)) // Nil
  // }
  // 正解
  // ただし、GitHubの模範の方が良い実装
  // def dropWhile[A](l: List[A], f: A => Boolean): List[A] = l match {
  //   case Cons(h, t) if f(h) => dropWhile(t, f)
  //   case _                  => l
  // }

  /** EXERCISE 3.6
    *
    * すべてがこのようにうまくいくわけではない。
    * Listの末尾を除くすべての要素で構成されたListを返すinit関数を実装せよ。
    * `List(1, 2, 3, 4)`が与えられた場合、initはList(1, 2, 3)を返す。
    * この関数をtailのように一定時間で実装できないのはなぜか。
    *
    * def init[A](l: List[A]): List[A]
    */
  // sealed trait List[+A]
  // case object Nil extends List[Nothing]
  // case class Cons[+A](h: A, t: List[A]) extends List[A]
  // object List {
  //   def apply[A](as: A*): List[A] =
  //     if (as.isEmpty) Nil
  //     else Cons(as.head, apply(as.tail: _*))

  //   // EXERCISE 3.6
  //   // 実行時間は引数のListの長さに比例する
  //   def init[A](l: List[A]): List[A] = l match {
  //     case Nil          => Nil
  //     case Cons(h, Nil) => Nil
  //     case Cons(h, t)   => Cons(h, init(t))
  //   }
  // }

  // def main(args: Array[String]): Unit = {
  //   println(List.init(List(1, 2, 3, 4))) // Cons(1,Cons(2,Cons(3,Nil)))
  //   println(List.init(Nil)) // Nil
  //   println(List.init(List(1))) // Nil
  // }
  // 正解
  // 引数のListが長いとスタックオーバーフローが起きる可能性がある

  /** EXERCISE 3.7
    *
    * foldRightを使って実装されたproductは、0.0を検出した場合に、直ちに再帰を中止して0.0を返せるか。
    * その理由を説明せよ。
    * 大きなリストでfoldRightを呼び出した場合の短絡の仕組みについて検討せよ。
    * この問題は奥が深いため、第5章で改めて取り上げる。
    */
  /** 返せない
    * 関数fはListをすべて走査するまで実行されずにコールスタックに蓄積されていく
    * 途中で0.0を検出してもスタックに蓄積された関数は中止できない
    */
  // 正解

  /** EXERCISE 3.8
    *
    * `foldRight(List(1, 2, 3), Nil: List[Int])(Cons(_, _))`のように、NilおよびCons自体をfoldRightに渡した場合はどうなるか。
    * これがfoldRightとListのデータコンストラクタとの関係について何を表していると思うか。
    */
  /** 同じListを作り直す
    */
  // 正解

  /** EXERCISE 3.9
    *
    * foldRightを使ってリストの長さを計算せよ。
    *
    * def length[A](as: List[A]): Int
    */
  // sealed trait List[+A]
  // case object Nil extends List[Nothing]
  // case class Cons[+A](h: A, t: List[A]) extends List[A]
  // object List {
  //   def apply[A](as: A*): List[A] =
  //     if (as.isEmpty) Nil
  //     else Cons(as.head, apply(as.tail: _*))
  //   def foldRight[A, B](as: List[A], z: B)(f: (A, B) => B): B = as match {
  //     case Nil         => z
  //     case Cons(x, xs) => f(x, foldRight(xs, z)(f))
  //   }

  //   // EXERCISE 3.9
  //   def length[A](as: List[A]): Int = foldRight(as, 0)((_, y) => y + 1)
  // }

  // def main(args: Array[String]): Unit = {
  //   println(List.length(List(1, 2, 3, 4))) // 4
  //   println(List.length(Nil)) // 0
  //   println(List.length(List(1))) // 1
  // }
  // 正解

  /** EXERCISE 3.10
    *
    * このfoldRightの実装は末尾再帰ではなく、リストが大きい場合はStackOverflowErrorになってしまう。
    * これをスタックセーフではないと言う。
    * そうした状況であると仮定し、前章で説明した手法を使って、リスト再帰の総称関数foldLeftを記述せよ。
    * シグネチャは以下のとおり。
    *
    * def foldLeft[A, B](as: List[A], z: B)(f: (B, A) => B): B
    */
  // sealed trait List[+A]
  // case object Nil extends List[Nothing]
  // case class Cons[+A](h: A, t: List[A]) extends List[A]
  // object List {
  //   def apply[A](as: A*): List[A] =
  //     if (as.isEmpty) Nil
  //     else Cons(as.head, apply(as.tail: _*))

  //   // EXERCISE 3.10
  //   def foldLeft[A, B](as: List[A], z: B)(f: (B, A) => B): B = as match {
  //     case Nil         => z
  //     case Cons(x, xs) => f(foldLeft(xs, z)(f), x)
  //   }
  // }

  // def main(args: Array[String]): Unit = {
  //   println(List.foldLeft(List(1, 2, 3, 4), 0)(_ + _)) // 10
  //   println(List.foldLeft(Nil: List[Int], 0)(_ + _)) // 0
  //   println(List.foldLeft(List(1), 0)(_ + _)) // 1
  // }
  // 結果は正しいが、末尾再帰になっていない
  // 以下が模範の実装
  // @annotation.tailrec
  // def foldLeft[A, B](as: List[A], z: B)(f: (B, A) => B): B = as match {
  //   case Nil         => z
  //   case Cons(x, xs) => foldLeft(xs, f(z, x))(f)
  // }

  /** EXERCISE 3.11
    *
    * foldLeftを使ってsum、product、およびリストの長さを計算する関数を記述せよ。
    *
    * def sum(ints: List[Int]): Int
    * def product(ds: List[Double]): Double
    * def length[A](as: List[A]): Int
    */
  // sealed trait List[+A]
  // case object Nil extends List[Nothing]
  // case class Cons[+A](h: A, t: List[A]) extends List[A]
  // object List {
  //   def apply[A](as: A*): List[A] =
  //     if (as.isEmpty) Nil
  //     else Cons(as.head, apply(as.tail: _*))

  //   @annotation.tailrec
  //   def foldLeft[A, B](as: List[A], z: B)(f: (B, A) => B): B = as match {
  //     case Nil         => z
  //     case Cons(x, xs) => foldLeft(xs, f(z, x))(f)
  //   }

  //   // EXERCISE 3.11
  //   def sum(ints: List[Int]): Int = foldLeft(ints, 0)(_ + _)

  //   def product(ds: List[Double]): Double = ds match {
  //     case Nil => 0.0
  //     case _   => foldLeft(ds, 1.0)(_ * _)
  //   }

  //   def length[A](as: List[A]): Int = foldLeft(as, 0)((x, _) => x + 1)
  // }

  // def main(args: Array[String]): Unit = {
  //   println(List.sum(List(1, 2, 3, 4))) // 10
  //   println(List.sum(Nil: List[Int])) // 0
  //   println(List.sum(List(1))) // 1

  //   println(List.product(List(1, 2, 3, 4))) // 24.0
  //   println(List.product(Nil: List[Double])) // 0.0
  //   println(List.product(List(1))) // 1.0

  //   println(List.length(List(1, 2, 3, 4))) // 4
  //   println(List.length(Nil: List[Int])) // 0
  //   println(List.length(List(1))) // 1
  // }
  // 正解

  /** EXERCISE 3.12
    *
    * 要素が逆に並んだリストを返す関数を記述せよ。
    * `List(1, 2, 3)`が与えられた場合、この関数は`List(3, 2, 1)`を返す。
    * 畳み込みを使って記述できるかどうかを確認すること。
    *
    * def reverse[A](l: List[A]): List[A]
    */
  // sealed trait List[+A]
  // case object Nil extends List[Nothing]
  // case class Cons[+A](h: A, t: List[A]) extends List[A]
  // object List {
  //   def apply[A](as: A*): List[A] =
  //     if (as.isEmpty) Nil
  //     else Cons(as.head, apply(as.tail: _*))

  //   @annotation.tailrec
  //   def foldLeft[A, B](as: List[A], z: B)(f: (B, A) => B): B = as match {
  //     case Nil         => z
  //     case Cons(x, xs) => foldLeft(xs, f(z, x))(f)
  //   }

  //   // EXERCISE 3.12
  //   def reverse[A](l: List[A]): List[A] = foldLeft(l, Nil: List[A])((x, y) => Cons(y, x))
  // }

  // def main(args: Array[String]): Unit = {
  //   println(List.reverse(List(1, 2, 3, 4))) // Cons(4,Cons(3,Cons(2,Cons(1,Nil))))
  //   println(List.reverse(Nil: List[Int])) // Nil
  //   println(List.reverse(List(1))) // Cons(1,Nil)
  // }
  // 正解

  /** EXERCISE 3.13
    *
    * foldRightをベースとしてfoldLeftを記述することは可能か。
    * その逆はどうか。
    * foldLeftを使ってfoldRightを実装すると、foldRightを末尾再帰的に実装することが可能となり、
    * 大きなリストでもスタックオーバーフローが発生しなくなるので便利である。
    */
  // sealed trait List[+A]
  // case object Nil extends List[Nothing]
  // case class Cons[+A](h: A, t: List[A]) extends List[A]
  // object List {
  //   def apply[A](as: A*): List[A] =
  //     if (as.isEmpty) Nil
  //     else Cons(as.head, apply(as.tail: _*))

  //   def foldRight[A, B](as: List[A], z: B)(f: (A, B) => B): B = as match {
  //     case Nil         => z
  //     case Cons(x, xs) => f(x, foldRight(xs, z)(f))
  //   }

  //   @annotation.tailrec
  //   def foldLeft[A, B](as: List[A], z: B)(f: (B, A) => B): B = as match {
  //     case Nil         => z
  //     case Cons(x, xs) => foldLeft(xs, f(z, x))(f)
  //   }

  //   // EXERCISE 3.13
  //   def foldLeftR[A, B](as: List[A], z: B)(f: (B, A) => B): B =
  //     foldRight(as, z)((a, b) => f(b, a))

  //   def foldRightL[A, B](as: List[A], z: B)(f: (A, B) => B): B =
  //     foldLeft(as, z)((b, a) => f(a, b))
  // }

  // def main(args: Array[String]): Unit = {
  //   println(List.foldLeftR(List(1, 2, 3, 4), 0)(_ + _)) // 10
  //   println(List.foldLeftR(Nil: List[Int], 0)(_ + _)) // 0
  //   println(List.foldLeftR(List(1), 0)(_ + _)) // 1

  //   println(List.foldRightL(List(1, 2, 3, 4), 0)(_ + _)) // 10
  //   println(List.foldRightL(Nil: List[Int], 0)(_ + _)) // 0
  //   println(List.foldRightL(List(1), 0)(_ + _)) // 1
  // }
  // 不正解
  // 計算結果は合ってるが模範と違う

  /** EXERCISE 3.14
    *
    * foldLeftまたはfoldRightをベースとしてappendを実装せよ。
    *
    * def append[A](a1: List[A], a2: List[A]): List[A]
    */
  // sealed trait List[+A]
  // case object Nil extends List[Nothing]
  // case class Cons[+A](h: A, t: List[A]) extends List[A]
  // object List {
  //   def apply[A](as: A*): List[A] =
  //     if (as.isEmpty) Nil
  //     else Cons(as.head, apply(as.tail: _*))

  //   def foldRight[A, B](as: List[A], z: B)(f: (A, B) => B): B = as match {
  //     case Nil         => z
  //     case Cons(x, xs) => f(x, foldRight(xs, z)(f))
  //   }

  //   @annotation.tailrec
  //   def foldLeft[A, B](as: List[A], z: B)(f: (B, A) => B): B = as match {
  //     case Nil         => z
  //     case Cons(x, xs) => foldLeft(xs, f(z, x))(f)
  //   }

  //   // EXERCISE 3.14
  //   def appendL[A](a1: List[A], a2: List[A]): List[A] =
  //     foldLeft(a1, a2)((b, a) => Cons(a, b))

  //   def appendR[A](a1: List[A], a2: List[A]): List[A] =
  //     foldRight(a1, a2)((a, b) => Cons(a, b))
  // }

  // def main(args: Array[String]): Unit = {
  //   println(List.appendL(List(1, 2), List(3, 4))) // Cons(2,Cons(1,Cons(3,Cons(4,Nil))))
  //   println(List.appendL(Nil: List[Int], Nil: List[Int])) // Nil
  //   println(List.appendL(List(1), Nil: List[Int])) // Cons(1,Nil)
  //   println(List.appendL(Nil: List[Int], List(1))) // Cons(1,Nil)

  //   println(List.appendR(List(1, 2), List(3, 4))) // Cons(1,Cons(2,Cons(3,Cons(4,Nil))))
  //   println(List.appendR(Nil: List[Int], Nil: List[Int])) // Nil
  //   println(List.appendR(List(1), Nil: List[Int])) // Cons(1,Nil)
  //   println(List.appendR(Nil: List[Int], List(1))) // Cons(1,Nil)
  // }
  // appendRは正解
  // appendLは不正解（たぶんreverseが必要）

  /** EXERCISE 3.15
    *
    * 複数のリストからなるリストを1つのリストとして連結する関数を記述せよ。
    * この関数の実行時間はすべてのリストの長さの合計に対して線型になるはずである。
    * すでに定義した関数を使ってみること。
    *
    * def flat[A](l: List[List[A]]): List[A]
    */
  // sealed trait List[+A]
  // case object Nil extends List[Nothing]
  // case class Cons[+A](h: A, t: List[A]) extends List[A]
  // object List {
  //   def apply[A](as: A*): List[A] =
  //     if (as.isEmpty) Nil
  //     else Cons(as.head, apply(as.tail: _*))

  //   def foldRight[A, B](as: List[A], z: B)(f: (A, B) => B): B = as match {
  //     case Nil         => z
  //     case Cons(x, xs) => f(x, foldRight(xs, z)(f))
  //   }

  //   def append[A](l1: List[A], l2: List[A]): List[A] = foldRight(l1, l2)(Cons(_, _))

  //   // EXERCISE 3.15
  //   def flat[A](l: List[List[A]]): List[A] =
  //     foldRight(l, Nil: List[A])((x, y) => append(x, y))
  // }

  // def main(args: Array[String]): Unit = {
  //   println(List.flat(List(List(1, 2), List(3, 4)))) // Cons(1,Cons(2,Cons(3,Cons(4,Nil))))
  //   println(List.flat(List(List(1), List(2), List(3, 4)))) // Cons(1,Cons(2,Cons(3,Cons(4,Nil))))
  //   println(List.flat(List(Nil: List[Int], Nil: List[Int]))) // Nil
  //   println(List.flat(List(List(1), Nil: List[Int]))) // Cons(1,Nil)
  //   println(List.flat(List(Nil: List[Int], List(1)))) // Cons(1,Nil)
  // }
  // 正解
  // GitHubの模範は以下
  // def concat[A](l: List[List[A]]): List[A] =
  //   foldRight(l, Nil: List[A])(append)

  /**
    */
}

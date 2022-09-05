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

  /** EXERCISE 3.16
    *
    * 各要素に1を足すことで整数のリストを変換する関数を記述せよ。
    * 注意：これは新しいListを返す純粋関数になるはずである。
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

  //   // EXERCISE 3.16
  //   def add[A](l: List[Int]): List[Int] =
  //     foldRight(l, Nil: List[Int])((x, y) => Cons(x + 1, y))
  // }

  // def main(args: Array[String]): Unit = {
  //   println(List.add(List(1, 2, 3, 4))) // Cons(2,Cons(3,Cons(4,Cons(5,Nil))))
  //   println(List.add(Nil: List[Int])) // Nil
  //   println(List.add(List(1))) // Cons(2,Nil)
  // }
  // 正解

  /** EXERCISE 3.17
    *
    * List[Double]の各値をStringに変換する関数を記述せよ。
    * `d.toString`という式を使って`d: Double`をStringに変換できる
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

  //   // EXERCISE 3.17
  //   def toString[A](l: List[Double]): List[String] =
  //     foldRight(l, Nil: List[String])((x, y) => Cons(x.toString, y))
  // }

  // def main(args: Array[String]): Unit = {
  //   println(List.toString(List(1.1, 2.2, 3.3, 4.4))) // Cons(1.1,Cons(2.2,Cons(3.3,Cons(4.4,Nil))))
  //   println(List.toString(List(1.1, 2.2, 3.3, 4.4)).isInstanceOf[List[String]]) // true
  //   println(List.toString(Nil: List[Double])) // Nil
  //   println(List.toString(Nil: List[Double]).isInstanceOf[List[String]]) // true
  //   println(List.toString(List(1.0))) // Cons(1.0,Nil)
  //   println(List.toString(List(1.0)).isInstanceOf[List[String]]) // true
  // }
  // 正解

  /** EXERCISE 3.18
    *
    * リストの各要素を変更し、かつリストの構造をそのまま保つ総称関数mapを記述せよ。
    * この関数のシグネチャは以下のとおり。
    *
    * def map[A, B](as: List[A])(f: A => B): List[B]
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

  //   // EXERCISE 3.18
  //   def map[A, B](as: List[A])(f: A => B): List[B] =
  //     foldRight(as, Nil: List[B])((x, y) => Cons(f(x), y))
  // }

  // def main(args: Array[String]): Unit = {
  //   println(List.map(List(1, 2, 3, 4))(_ + 1)) // Cons(2,Cons(3,Cons(4,Cons(5,Nil))))
  //   println(List.map(Nil: List[Int])(_ + 1)) // Nil
  //   println(List.map(List(1))(_ + 1)) // Cons(2,Nil)
  // }
  // 正解

  /** EXERCISE 3.19
    *
    * 与えられた述語条件が満たされるまでリストから要素を削除するfilter関数を記述せよ。
    * この関数を使ってList[Int]から奇数をすべて削除せよ。
    *
    * def filter[A](as: List[A])(f: A => Boolean): List[A]
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

  //   // EXERCISE 3.19
  //   def filter[A](as: List[A])(f: A => Boolean): List[A] =
  //     foldRight(as, Nil: List[A])((x, y) => if (f(x)) Cons(x, y) else y)
  // }

  // def main(args: Array[String]): Unit = {
  //   println(List.filter(List(1, 2, 3, 4))(_ % 2 == 0)) // Cons(2,Cons(4,Nil))
  //   println(List.filter(Nil: List[Int])(_ % 2 == 0)) // Nil
  //   println(List.filter(List(1))(_ % 2 == 0)) // Nil
  //   println(List.filter(List(2))(_ % 2 == 0)) // Cons(2,Nil)
  // }
  // 正解

  /** EXERCISE 3.20
    *
    * mapと同じような働きをするflatMap関数を記述せよ。
    * この関数は単一の結果ではなくリストを返し、そのリストは最終的な結果のリストに挿入されなければならない。
    * この関数のシグネチャは以下のとおり。
    *
    * def flatMap[A, B](as: List[A])(f: A => List[B]): List[B]
    *
    * たとえば`flatMap(List(1, 2, 3))(i => List(i, i))`は`List(1, 1, 2, 2, 3, 3)`になるはずである。
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

  //   // EXERCISE 3.20
  //   def flatMap[A, B](as: List[A])(f: A => List[B]): List[B] =
  //     foldRight(as, Nil: List[B])((x, y) => append(f(x), y))
  // }

  // def main(args: Array[String]): Unit = {
  //   println(List.flatMap(List(1, 2, 3))(i => List(i, i))) // Cons(1,Cons(1,Cons(2,Cons(2,Cons(3,Cons(3,Nil))))))
  //   println(List.flatMap(Nil: List[Int])(i => List(i, i))) // Nil
  //   println(List.flatMap(List(1))(i => List(i, i))) // Cons(1,Cons(1,Nil))
  // }
  // 正解
  // GitHubの模範は以下
  // def flatMap[A, B](as: List[A])(f: A => List[B]): List[B] =
  //   concat(map(l, f))

  /** EXERCISE 3.21
    *
    * flatMapを使ってfilterを実装せよ。
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

  //   def flatMap[A, B](as: List[A])(f: A => List[B]): List[B] =
  //     foldRight(as, Nil: List[B])((x, y) => append(f(x), y))

  //   // EXERCISE 3.21
  //   def filter[A](as: List[A])(f: A => Boolean): List[A] =
  //     flatMap(as)(x => if (f(x)) List(x) else Nil)
  // }

  // def main(args: Array[String]): Unit = {
  //   println(List.filter(List(1, 2, 3, 4))(_ % 2 == 0)) // Cons(2,Cons(4,Nil))
  //   println(List.filter(Nil: List[Int])(_ % 2 == 0)) // Nil
  //   println(List.filter(List(1))(_ % 2 == 0)) // Nil
  //   println(List.filter(List(2))(_ % 2 == 0)) // Cons(2,Nil)
  // }
  // 正解

  /** EXERCISE 3.22
    *
    * リストを2つ受け取り、対応する要素どうしを足し合わせて新しいリストを生成する関数を記述せよ。
    * たとえば`List(1, 2, 3)`と`List(4, 5, 6)`は`List(5, 7, 9)`になる
    */
  // sealed trait List[+A]
  // case object Nil extends List[Nothing]
  // case class Cons[+A](h: A, t: List[A]) extends List[A]
  // object List {
  //   def apply[A](as: A*): List[A] =
  //     if (as.isEmpty) Nil
  //     else Cons(as.head, apply(as.tail: _*))

  //   // EXERCISE 3.22
  //   def addList(l1: List[Int], l2: List[Int]): List[Int] = (l1, l2) match {
  //     case (Cons(h1, t1), Cons(h2, t2)) => Cons(h1 + h2, addList(t1, t2))
  //     case _                            => Nil
  //   }
  // }

  // def main(args: Array[String]): Unit = {
  //   println(List.addList(List(1, 2, 3), List(4, 5, 6))) // Cons(5,Cons(7,Cons(9,Nil)))
  //   println(List.addList(Nil: List[Int], Nil: List[Int])) // Nil
  //   println(List.addList(List(1), Nil: List[Int])) // Nil
  //   println(List.addList(Nil: List[Int], List(1))) // Nil
  // }
  // 正解

  /** EXERCISE 3.23
    *
    * EXERCISE 3.22で作成した関数を、整数または加算に限定されないように一般化せよ。
    * 一般化された関数にはzipWithという名前を付けること。
    */
  // sealed trait List[+A]
  // case object Nil extends List[Nothing]
  // case class Cons[+A](h: A, t: List[A]) extends List[A]
  // object List {
  //   def apply[A](as: A*): List[A] =
  //     if (as.isEmpty) Nil
  //     else Cons(as.head, apply(as.tail: _*))

  //   // EXERCISE 3.23
  //   def zipWith[A](l1: List[A], l2: List[A])(f: (A, A) => A): List[A] = (l1, l2) match {
  //     case (Cons(h1, t1), Cons(h2, t2)) => Cons(f(h1, h2), zipWith(t1, t2)(f))
  //     case _                            => Nil
  //   }
  // }

  // def main(args: Array[String]): Unit = {
  //   println(List.zipWith(List("1", "2", "3"), List("4", "5", "6"))(_ + _)) // Cons(14,Cons(25,Cons(36,Nil)))
  //   println(List.zipWith(List(1, 2, 3), List(4, 5, 6))(_ + _)) // Cons(5,Cons(7,Cons(9,Nil)))
  //   println(List.zipWith(Nil: List[Int], Nil: List[Int])(_ + _)) // Nil
  //   println(List.zipWith(List(1), Nil: List[Int])(_ + _)) // Nil
  //   println(List.zipWith(Nil: List[Int], List(1))(_ + _)) // Nil
  // }
  // 正解

  /** EXERCISE 3.24
    *
    * 例として、Listに別のListがサブシーケンスとして含まれているかどうかを調べるhasSubsequenceを実装せよ。
    * たとえば`List(1, 2, 3, 4)`には、`List(1, 2)`、`List(2, 3)`、`List(4)`などがサブシーケンスとして含まれている。
    * 純粋関数型で、コンパクトで、かつ効率的な実装を見つけ出すのは難しいかもしれない。
    * その場合は、それでかまわない。
    * どのようなものであれ、もっとも自然な関数を実装すること。
    * この実装については、第5章で改めて取り上げ、改良する予定である。
    * なおScalaでは、任意の値xおよびyに対し、`x == y`という式を使って等しいかどうかを比較できる。
    *
    * def hasSubsequence[A](sup: List[A], sub: List[A]): Boolean
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

  //   // EXERCISE 3.24
  //   def hasSubsequence[A](sup: List[A], sub: List[A]): Boolean = {
  //     (sup, sub) match {
  //       case (_, Nil)                                => true
  //       case (Nil, _)                                => false
  //       case (Cons(h, t), Cons(h2, t2)) if (h == h2) => hasSubsequence(t, t2)
  //       case (Cons(h, t), Cons(h2, t2)) if (h != h2) => hasSubsequence(t, sub)
  //     }
  //   }
  // }

  // def main(args: Array[String]): Unit = {
  //   println(List.hasSubsequence(List(1, 2, 3), List(1, 2))) // true
  //   println(List.hasSubsequence(List(1, 2, 3), List(2, 3))) // true
  //   println(List.hasSubsequence(List(1, 2, 3), List(1, 3))) // false
  //   println(List.hasSubsequence(List(1, 2, 3), List(2, 1))) // false
  //   println(List.hasSubsequence(Nil, List(1, 2))) // false
  //   println(List.hasSubsequence(List(1), List(1))) // true
  //   println(List.hasSubsequence(List(1), Nil)) // true
  // }
  // 不正解
  // GitHubの模範は以下
  // @annotation.tailrec
  // def startsWith[A](l: List[A], prefix: List[A]): Boolean = (l, prefix) match {
  //   case (_, Nil)                              => true
  //   case (Cons(h, t), Cons(h2, t2)) if h == h2 => startsWith(t, t2)
  //   case _                                     => false
  // }

  // @annotation.tailrec
  // def hasSubsequence[A](sup: List[A], sub: List[A]): Boolean = sup match {
  //   case Nil                       => sub == Nil
  //   case _ if startsWith(sup, sub) => true
  //   case Cons(h, t)                => hasSubsequence(t, sub)
  // }

  /**
    */
}

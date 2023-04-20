package `202208`

object Chapter10 {
  // trait Monoid[A] {
  //   // `op(op(x, y), z) == op(x, op(y, z))`を満たす
  //   def op(a1: A, a2: A): A

  //   // `op(x, zero) == x`および`op(zero, x) == x`を満たす
  //   def zero: A
  // }

  // val stringMonoid = new Monoid[String] {
  //   def op(a1: String, a2: String) = a1 + a2
  //   val zero = ""
  // }
  // def listMonoid[A] = new Monoid[List[A]] {
  //   def op(a1: List[A], a2: List[A]) = a1 ++ a2
  //   val zero = Nil
  // }

  /** EXERCISE 10.1
    *
    * 整数の加算と乗算、および論理演算子に対するMonoidインスタンスを考え出せ。
    *
    * val intAddition: Monoid[Int]
    * val intMultiplication: Monoid[Int]
    * val booleanOr: Monoid[Boolean]
    * val booleanAnd: Monoid[Boolean]
    */
  // trait Monoid[A] {
  //   def op(a1: A, a2: A): A
  //   def zero: A
  // }

  // val intAddition: Monoid[Int] = new Monoid[Int] {
  //   def op(a1: Int, a2: Int): Int = a1 + a1
  //   val zero = 0
  // }

  // val intMultiplication: Monoid[Int] = new Monoid[Int] {
  //   def op(a1: Int, a2: Int): Int = a1 * a2
  //   val zero = 1
  // }

  // val booleanOr: Monoid[Boolean] = new Monoid[Boolean] {
  //   def op(a1: Boolean, a2: Boolean): Boolean = a1 || a2
  //   val zero = false
  // }

  // val booleanAnd: Monoid[Boolean] = new Monoid[Boolean] {
  //   def op(a1: Boolean, a2: Boolean): Boolean = a1 && a2
  //   val zero = true
  // }
  // 正解

  /**
    */
}

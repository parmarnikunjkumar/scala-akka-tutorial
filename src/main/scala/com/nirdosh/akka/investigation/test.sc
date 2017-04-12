def multiply(implicit by :Int) = 2 * by

implicit val multiplier = 2


multiply

multiply(5)

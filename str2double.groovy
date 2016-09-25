/**
 * Created by roman on 9/25/16.
 */
def pw = new File('outs').newPrintWriter()
outs = 75.0
step = 300
for (i in 0..4320000) {
    if (Math.random() < 0.5) outs = outs - Math.random() / 1000
    if (Math.random() > 0.5) outs = outs + Math.random() / 1000
    pw.println(outs)
}
def open_  = new File('open').newPrintWriter()
def high_  = new File('high').newPrintWriter()
def low_   = new File('low').newPrintWriter()
def close_ = new File('close').newPrintWriter()
open  = 0.0
high  = 0.0
low   = 0.0
close = 0.0
BigInteger counter = 1
start = true
current  = 0.0
new File('outs').eachLine {
    if ((counter % step == 1)   && (start == true))  {open = high = close = low = it.toBigDecimal()
        start = false}
    if ((counter % step == 1)   && (start == false))  {high = close = low = it.toBigDecimal()
        start = false}
    if (counter % step == 0)    {close = it.toBigDecimal()
        open_.println(open)
        close_.println(close)
        high_.println(high)
        low_.println(low)
        open = close}
    current = it.toBigDecimal()
    if (current > high) high = current
    if (current < low) low = current
    counter = counter + 1
}
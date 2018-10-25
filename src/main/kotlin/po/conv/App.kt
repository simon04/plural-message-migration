package po.conv

import org.fedorahosted.tennera.jgettext.PoParser
import org.fedorahosted.tennera.jgettext.PoWriter
import java.io.File

fun main(args: Array<String>) {
    convertCS()
    convertSK()
}

private fun convertCS() {
    val file = File("po/cs.po")
    val catalog = PoParser().parseCatalog(file)
    val header = catalog.locateHeader()
    header.msgstr = header.msgstr.replace(
            "Plural-Forms: nplurals=3; plural=(n==1) ? 0 : (n>=2 && n<=4) ? 1 : 2;",
            "Plural-Forms: nplurals=4; plural=(n == 1 && n % 1 == 0) ? 0 : (n >= 2 && n <= 4 && n % 1 == 0) ? 1: (n % 1 != 0 ) ? 2 : 3;"
    )
    catalog.filter { it.isPlural && it.msgstrPlural.size == 3 }.forEach {
        it.msgstrPlural.add(it.msgstrPlural[2])
    }
    PoWriter().write(catalog, file)
}

private fun convertSK() {
    val file = File("po/sk.po")
    val catalog = PoParser().parseCatalog(file)
    val header = catalog.locateHeader()
    header.msgstr = header.msgstr.replace(
            "Plural-Forms: nplurals=3; plural=(n==1) ? 1 : (n>=2 && n<=4) ? 2 : 0;",
            "Plural-Forms: nplurals=4; plural=(n % 1 == 0 && n == 1 ? 0 : n % 1 == 0 && n >= 2 && n <= 4 ? 1 : n % 1 != 0 ? 2: 3);"
    )
    catalog.filter { it.isPlural && it.msgstrPlural.size == 3 }.forEach {
        val (p0, p1, p2) = it.msgstrPlural
        // https://josm.openstreetmap.de/ticket/8645#comment:129
        it.msgstrPlural[0] = p1
        it.msgstrPlural[1] = p2
        it.msgstrPlural[2] = p0
        it.msgstrPlural.add(p0)
    }
    PoWriter().write(catalog, file)
}

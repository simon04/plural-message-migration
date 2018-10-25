package po.conv

import org.fedorahosted.tennera.jgettext.PoParser
import org.fedorahosted.tennera.jgettext.PoWriter
import java.io.File

fun main(args: Array<String>) {
    convertBE()
    convertCS()
    convertLT()
    convertSK()
    convertPL()
    convertRU()
    convertUK()
}

private fun convertBE() {
    val file = File("po/be.po")
    val catalog = PoParser().parseCatalog(file)
    val header = catalog.locateHeader()
    header.msgstr = header.msgstr.replace(
            "Plural-Forms: nplurals=3; plural=(n%10==1 && n%100!=11 ? 0 : n%10>=2 && \"\n\"n%10<=4 && (n%100<10 || n%100>=20) ? 1 : 2);",
            "Plural-Forms: nplurals=4; plural=(n%10==1 && n%100!=11 ? 0 : n%10>=2 && n%10<=4 && (n%100<12 || n%100>14) ? 1 : n%10==0 || (n%10>=5 && n%10<=9) || (n%100>=11 && n%100<=14)? 2 : 3);"
    )
    catalog.filter { it.isPlural && it.msgstrPlural.size == 3 }.forEach {
        it.msgstrPlural.add(it.msgstrPlural[2])
    }
    PoWriter().write(catalog, file)
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

private fun convertLT() {
    val file = File("po/lt.po")
    val catalog = PoParser().parseCatalog(file)
    val header = catalog.locateHeader()
    header.msgstr = header.msgstr.replace(
            "Plural-Forms: nplurals=3; plural=n%10==1 && n%100!=11 ? 0 : n%10>=2 && \"\n\"(n%100<10 || n%100>=20) ? 1 : 2;",
            "Plural-Forms: nplurals=4; plural=(n % 10 == 1 && (n % 100 > 19 || n % 100 < 11) ? 0 : (n % 10 >= 2 && n % 10 <=9) && (n % 100 > 19 || n % 100 < 11) ? 1 : n % 1 != 0 ? 2: 3);"
    )
    catalog.filter { it.isPlural && it.msgstrPlural.size == 3 }.forEach {
        it.msgstrPlural.add(2, it.msgstrPlural[2])
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

private fun convertPL() {
    val file = File("po/pl.po")
    val catalog = PoParser().parseCatalog(file)
    val header = catalog.locateHeader()
    header.msgstr = header.msgstr.replace(
            "Plural-Forms: nplurals=3; plural=n==1 ? 0 : n%10>=2 && n%10<=4 && (n%100<10 \"\n\"|| n%100>=20) ? 1 : 2;",
            "Plural-Forms: nplurals=4; plural=(n==1 ? 0 : (n%10>=2 && n%10<=4) && (n%100<12 || n%100>14) ? 1 : n!=1 && (n%10>=0 && n%10<=1) || (n%10>=5 && n%10<=9) || (n%100>=12 && n%100<=14) ? 2 : 3);"
    )
    catalog.filter { it.isPlural && it.msgstrPlural.size == 3 }.forEach {
        it.msgstrPlural.add(it.msgstrPlural[2])
    }
    PoWriter().write(catalog, file)
}

private fun convertRU() {
    val file = File("po/ru.po")
    val catalog = PoParser().parseCatalog(file)
    val header = catalog.locateHeader()
    header.msgstr = header.msgstr.replace(
            "Plural-Forms: nplurals=3; plural=n%10==1 && n%100!=11 ? 0 : n%10>=2 && \"\n\"n%10<=4 && (n%100<10 || n%100>=20) ? 1 : 2;",
            "Plural-Forms: nplurals=4; plural=(n%10==1 && n%100!=11 ? 0 : n%10>=2 && n%10<=4 && (n%100<12 || n%100>14) ? 1 : n%10==0 || (n%10>=5 && n%10<=9) || (n%100>=11 && n%100<=14)? 2 : 3);"
    )
    catalog.filter { it.isPlural && it.msgstrPlural.size == 3 }.forEach {
        it.msgstrPlural.add(it.msgstrPlural[2])
    }
    PoWriter().write(catalog, file)
}

private fun convertUK() {
    val file = File("po/uk.po")
    val catalog = PoParser().parseCatalog(file)
    val header = catalog.locateHeader()
    header.msgstr = header.msgstr.replace(
            "Plural-Forms: nplurals=3; plural=n%10==1 && n%100!=11 ? 0 : n%10>=2 && \"\n\"n%10<=4 && (n%100<10 || n%100>=20) ? 1 : 2;",
            "Plural-Forms: nplurals=4; plural=(n % 1 == 0 && n % 10 == 1 && n % 100 != 11 ? 0 : n % 1 == 0 && n % 10 >= 2 && n % 10 <= 4 && (n % 100 < 12 || n % 100 > 14) ? 1 : n % 1 == 0 && (n % 10 ==0 || (n % 10 >=5 && n % 10 <=9) || (n % 100 >=11 && n % 100 <=14 )) ? 2: 3);"
    )
    catalog.filter { it.isPlural && it.msgstrPlural.size == 3 }.forEach {
        it.msgstrPlural.add(it.msgstrPlural[2])
    }
    PoWriter().write(catalog, file)
}

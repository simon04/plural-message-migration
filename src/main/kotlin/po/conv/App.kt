package po.conv

import org.fedorahosted.tennera.jgettext.PoParser
import org.fedorahosted.tennera.jgettext.PoWriter
import java.io.File

fun main(args: Array<String>) {
    convertCS()
}

private fun convertCS() {
    val file = File("../po/cs.po")
    val catalog = PoParser().parseCatalog(file)
    val header = catalog.locateHeader()
    header.msgstr = header.msgstr.replace(
            "Plural-Forms: nplurals=3; plural=(n==1) ? 0 : (n>=2 && n<=4) ? 1 : 2;",
            "Plural-Forms: nplurals=4; plural=(n == 1 && n % 1 == 0) ? 0 : (n >= 2 && n <= 4 && n % 1 == 0) ? 1: (n % 1 != 0 ) ? 2 : 3;"
    )
    catalog.filter { it.isPlural }.forEach {
        it.addMsgstrPlural(it.msgstrPlural[2], 3)
    }
    PoWriter().write(catalog, file)
}

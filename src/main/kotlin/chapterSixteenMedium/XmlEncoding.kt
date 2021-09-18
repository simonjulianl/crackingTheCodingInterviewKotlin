package chapterSixteenMedium

/**
 * encode(v: String, sb: StringBuilder) sb.append(v), sb.append(" ")
 * fun encode(root: Element, sb: StringBuilder)
 *  encode(root.getNameCode(), sb)
 *  for (attr in root.attributes) encode(a, sb)
 *  encode ("0", sb)
 *
 *  if (root.value != null && root.value != "") encode(root.value, sb)
 *  else
 *  for (each element in root.children) encode (e , sb)
 *
 *  encode (0, sb)
 */

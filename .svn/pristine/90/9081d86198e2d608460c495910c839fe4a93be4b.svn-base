package locationIndex;

import java.util.Arrays;
import java.util.List;

import org.apache.lucene.analysis.util.CharArraySet;
import org.apache.lucene.util.Version;


/*
 * Stopper che contiene le parole da non indicizzare
 */
public class Stopper {
	public Stopper() {
	}

	public CharArraySet giveStopWords() {
		final List<String> stopWords = Arrays.asList(":", "/", "&", "–", "a.",
				"a", "A.", "A'", "A", "à", "Å", "A1", "Aa", "AA", "Ab", "AB",
				"Ac", "ad", "Ad", "Ae", "�?g", "Ah", "ai", "Ai", "Ải", "Ak",
				"al", "Al", "AL", "Ål", "am", "Am", "an", "An", "Ân", "ao",
				"Ao", "Aq", "ar", "Ar", "AR", "as", "As", "Ås", "Aš", "at",
				"At", "au", "Au", "Av", "aw", "Aw", "Ax", "Ay", "az", "Az",
				"B.", "B", "Ba", "Bá", "Bà", "Be", "BG", "Bi", "Bị", "Bo",
				"Bố", "Bô", "Bő", "Bø", "Bu", "Bû", "by", "By", "C.", "C",
				"Ca", "Cà", "CC", "Cé", "ch", "Co", "Có", "Cố", "Cổ", "Cô",
				"Cu", "Cù", "Cư", "d'", "D", "da", "Da", "�?a", "�?á", "DC",
				"de", "De", "Dé", "di", "Di", "Dị", "do", "Do", "�?ồ", "�?�?",
				"Dr", "du", "Du", "DY", "e", "E)", "E", "Ea", "ed", "Ed", "Ee",
				"Eg", "Ei", "Ek", "el", "El", "Em", "en", "En", "Eo", "Er",
				"es", "Es", "ès", "et", "Et", "Eu", "Ex", "ez", "EZ", "F",
				"Fa", "Fe", "Fé", "FM", "Fo", "Fu", "G.", "G", "Ga", "Gi",
				"Go", "Gò", "gu", "Gu", "Gy", "H", "Ha", "Há", "Hà", "Hå",
				"Hạ", "He", "Hi", "ho", "Ho", "Hò", "Hồ", "Hộ", "Hy", "Hỷ",
				"i", "I.", "I", "í", "Ia", "Iċ", "Ie", "Ig", "Ii", "II", "il",
				"im", "in", "In", "Io", "Ip", "Ir", "It", "IV", "J.", "J",
				"Ja", "Ji", "Jo", "Jr", "K.", "K", "ka", "Ka", "Ke", "Ké",
				"ki", "Ki", "KL", "KM", "ko", "Ko", "ku", "Ky", "Kỳ", "Kỷ",
				"KZ", "l", "L.", "L", "la", "La", "LA", "Lâ", "le", "Le", "Lễ",
				"Lệ", "Lê", "li", "Li", "lo", "Lo", "Lỗ", "Lộ", "Lô", "Lu",
				"Lû", "Lü", "Lư", "Ly", "Lý", "M.", "M", "Ma", "Mc", "Me",
				"Mé", "Mi", "MI", "mí", "Mo", "MO", "Mô", "MS", "Mu", "My",
				"Mỹ", "n", "N.", "N'", "N", "na", "Na", "NB", "Ne", "NE", "Né",
				"Nê", "ni", "Ni", "No", "Ny", "NY", "o'", "o", "O'", "O", "ô",
				"Ô", "Oa", "ob", "Ob", "Óc", "od", "Ōe", "of", "Of", "og",
				"Oi", "OK", "ol", "on", "On", "Oo", "op", "Op", "or", "Or",
				"�?r", "os", "Os", "Oś", "Ou", "Ov", "Ox", "Oy", "Oz", "P.",
				"P", "Pa", "Pâ", "p�?", "Pe", "Pé", "pi", "Pi", "Po", "Pô",
				"Pu", "Py", "Q", "Qi", "R.", "R'", "R", "Ř", "Ra", "Rã", "Rd",
				"Re", "Ré", "Ri", "Ro", "Ru", "RV", "Ry", "'s", "S.", "S",
				"sa", "Sa", "Sâ", "Se", "SE", "Sé", "SH", "Si", "Sĩ", "SK",
				"So", "Sô", "St", "su", "Su", "Sy", "'t", "T.", "T", "Ta",
				"Tá", "Tà", "Tạ", "TB", "te", "Te", "Ti", "Tl", "TN", "to",
				"To", "Tô", "Tơ", "Tu", "Tú", "Tự", "Tư", "TX", "Ty", "Tŷ",
				"u", "U", "Ub", "Uk", "Um", "un", "Un", "Up", "Ur", "Us", "v",
				"V.", "V", "va", "Va", "VA", "ve", "Ve", "vi", "Vi", "VI",
				"Vĩ", "Vị", "Vo", "Vô", "Võ", "Vu", "Vũ", "Vy", "W", "wa",
				"Wa", "Wm", "Wo", "Wu", "Wy", "X", "Xá", "Xà", "XI", "XX", "y",
				"Y", "ya", "ye", "Ye", "Yé", "Yi", "ym", "yn", "yr", "Yu", "Z",
				"Ž", "Za", "Zè", "Zi", "ZR", "Zu");
		final CharArraySet stopSet = new CharArraySet(Version.LUCENE_47,
				stopWords, false);

		return stopSet;

	}

}

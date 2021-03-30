// Generated from /Users/colinholzman/makina/makina-compiler/src/makina.g4 by ANTLR 4.9.1
package xyz.colinholzman.makina;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class makinaLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, ID=17, 
		WHITESPACE=18, COMMENT=19;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "ID", "WHITESPACE", 
			"COMMENT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'machine'", "';'", "'{'", "'}'", "'initial'", "'state'", "'parallel'", 
			"'final'", "'.'", "'entry'", "'exit'", "'on'", "'('", "')'", "'->'", 
			"'-->'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, "ID", "WHITESPACE", "COMMENT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public makinaLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "makina.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\25\u0093\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\4"+
		"\3\4\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3"+
		"\17\3\17\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\22\3\22\7\22r\n\22\f\22"+
		"\16\22u\13\22\3\22\3\22\6\22y\n\22\r\22\16\22z\3\22\5\22~\n\22\3\23\3"+
		"\23\3\23\3\23\3\24\3\24\3\24\3\24\7\24\u0088\n\24\f\24\16\24\u008b\13"+
		"\24\3\24\5\24\u008e\n\24\3\24\3\24\3\24\3\24\2\2\25\3\3\5\4\7\5\t\6\13"+
		"\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'"+
		"\25\3\2\7\5\2C\\aac|\6\2\62;C\\aac|\3\2bb\5\2\13\f\16\17\"\"\4\2\f\f\17"+
		"\17\2\u0097\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2"+
		"\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27"+
		"\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2"+
		"\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\3)\3\2\2\2\5\61\3\2\2\2\7\63\3\2"+
		"\2\2\t\65\3\2\2\2\13\67\3\2\2\2\r?\3\2\2\2\17E\3\2\2\2\21N\3\2\2\2\23"+
		"T\3\2\2\2\25V\3\2\2\2\27\\\3\2\2\2\31a\3\2\2\2\33d\3\2\2\2\35f\3\2\2\2"+
		"\37h\3\2\2\2!k\3\2\2\2#}\3\2\2\2%\177\3\2\2\2\'\u0083\3\2\2\2)*\7o\2\2"+
		"*+\7c\2\2+,\7e\2\2,-\7j\2\2-.\7k\2\2./\7p\2\2/\60\7g\2\2\60\4\3\2\2\2"+
		"\61\62\7=\2\2\62\6\3\2\2\2\63\64\7}\2\2\64\b\3\2\2\2\65\66\7\177\2\2\66"+
		"\n\3\2\2\2\678\7k\2\289\7p\2\29:\7k\2\2:;\7v\2\2;<\7k\2\2<=\7c\2\2=>\7"+
		"n\2\2>\f\3\2\2\2?@\7u\2\2@A\7v\2\2AB\7c\2\2BC\7v\2\2CD\7g\2\2D\16\3\2"+
		"\2\2EF\7r\2\2FG\7c\2\2GH\7t\2\2HI\7c\2\2IJ\7n\2\2JK\7n\2\2KL\7g\2\2LM"+
		"\7n\2\2M\20\3\2\2\2NO\7h\2\2OP\7k\2\2PQ\7p\2\2QR\7c\2\2RS\7n\2\2S\22\3"+
		"\2\2\2TU\7\60\2\2U\24\3\2\2\2VW\7g\2\2WX\7p\2\2XY\7v\2\2YZ\7t\2\2Z[\7"+
		"{\2\2[\26\3\2\2\2\\]\7g\2\2]^\7z\2\2^_\7k\2\2_`\7v\2\2`\30\3\2\2\2ab\7"+
		"q\2\2bc\7p\2\2c\32\3\2\2\2de\7*\2\2e\34\3\2\2\2fg\7+\2\2g\36\3\2\2\2h"+
		"i\7/\2\2ij\7@\2\2j \3\2\2\2kl\7/\2\2lm\7/\2\2mn\7@\2\2n\"\3\2\2\2os\t"+
		"\2\2\2pr\t\3\2\2qp\3\2\2\2ru\3\2\2\2sq\3\2\2\2st\3\2\2\2t~\3\2\2\2us\3"+
		"\2\2\2vx\7b\2\2wy\n\4\2\2xw\3\2\2\2yz\3\2\2\2zx\3\2\2\2z{\3\2\2\2{|\3"+
		"\2\2\2|~\7b\2\2}o\3\2\2\2}v\3\2\2\2~$\3\2\2\2\177\u0080\t\5\2\2\u0080"+
		"\u0081\3\2\2\2\u0081\u0082\b\23\2\2\u0082&\3\2\2\2\u0083\u0084\7\61\2"+
		"\2\u0084\u0085\7\61\2\2\u0085\u0089\3\2\2\2\u0086\u0088\n\6\2\2\u0087"+
		"\u0086\3\2\2\2\u0088\u008b\3\2\2\2\u0089\u0087\3\2\2\2\u0089\u008a\3\2"+
		"\2\2\u008a\u008d\3\2\2\2\u008b\u0089\3\2\2\2\u008c\u008e\7\17\2\2\u008d"+
		"\u008c\3\2\2\2\u008d\u008e\3\2\2\2\u008e\u008f\3\2\2\2\u008f\u0090\7\f"+
		"\2\2\u0090\u0091\3\2\2\2\u0091\u0092\b\24\2\2\u0092(\3\2\2\2\b\2sz}\u0089"+
		"\u008d\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
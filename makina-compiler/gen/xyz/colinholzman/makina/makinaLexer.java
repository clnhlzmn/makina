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
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, ID=15, WHITESPACE=16, 
		COMMENT=17;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "ID", "WHITESPACE", "COMMENT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'machine'", "';'", "'initial'", "'state'", "'{'", "'}'", "'.'", 
			"'entry'", "'exit'", "'on'", "'('", "')'", "'->'", "'>'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, "ID", "WHITESPACE", "COMMENT"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\23~\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\16"+
		"\3\17\3\17\3\20\3\20\7\20]\n\20\f\20\16\20`\13\20\3\20\3\20\6\20d\n\20"+
		"\r\20\16\20e\3\20\5\20i\n\20\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\7"+
		"\22s\n\22\f\22\16\22v\13\22\3\22\5\22y\n\22\3\22\3\22\3\22\3\22\2\2\23"+
		"\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20"+
		"\37\21!\22#\23\3\2\7\5\2C\\aac|\6\2\62;C\\aac|\3\2bb\5\2\13\f\16\17\""+
		"\"\4\2\f\f\17\17\2\u0082\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2"+
		"\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25"+
		"\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2"+
		"\2\2\2!\3\2\2\2\2#\3\2\2\2\3%\3\2\2\2\5-\3\2\2\2\7/\3\2\2\2\t\67\3\2\2"+
		"\2\13=\3\2\2\2\r?\3\2\2\2\17A\3\2\2\2\21C\3\2\2\2\23I\3\2\2\2\25N\3\2"+
		"\2\2\27Q\3\2\2\2\31S\3\2\2\2\33U\3\2\2\2\35X\3\2\2\2\37h\3\2\2\2!j\3\2"+
		"\2\2#n\3\2\2\2%&\7o\2\2&\'\7c\2\2\'(\7e\2\2()\7j\2\2)*\7k\2\2*+\7p\2\2"+
		"+,\7g\2\2,\4\3\2\2\2-.\7=\2\2.\6\3\2\2\2/\60\7k\2\2\60\61\7p\2\2\61\62"+
		"\7k\2\2\62\63\7v\2\2\63\64\7k\2\2\64\65\7c\2\2\65\66\7n\2\2\66\b\3\2\2"+
		"\2\678\7u\2\289\7v\2\29:\7c\2\2:;\7v\2\2;<\7g\2\2<\n\3\2\2\2=>\7}\2\2"+
		">\f\3\2\2\2?@\7\177\2\2@\16\3\2\2\2AB\7\60\2\2B\20\3\2\2\2CD\7g\2\2DE"+
		"\7p\2\2EF\7v\2\2FG\7t\2\2GH\7{\2\2H\22\3\2\2\2IJ\7g\2\2JK\7z\2\2KL\7k"+
		"\2\2LM\7v\2\2M\24\3\2\2\2NO\7q\2\2OP\7p\2\2P\26\3\2\2\2QR\7*\2\2R\30\3"+
		"\2\2\2ST\7+\2\2T\32\3\2\2\2UV\7/\2\2VW\7@\2\2W\34\3\2\2\2XY\7@\2\2Y\36"+
		"\3\2\2\2Z^\t\2\2\2[]\t\3\2\2\\[\3\2\2\2]`\3\2\2\2^\\\3\2\2\2^_\3\2\2\2"+
		"_i\3\2\2\2`^\3\2\2\2ac\7b\2\2bd\n\4\2\2cb\3\2\2\2de\3\2\2\2ec\3\2\2\2"+
		"ef\3\2\2\2fg\3\2\2\2gi\7b\2\2hZ\3\2\2\2ha\3\2\2\2i \3\2\2\2jk\t\5\2\2"+
		"kl\3\2\2\2lm\b\21\2\2m\"\3\2\2\2no\7\61\2\2op\7\61\2\2pt\3\2\2\2qs\n\6"+
		"\2\2rq\3\2\2\2sv\3\2\2\2tr\3\2\2\2tu\3\2\2\2ux\3\2\2\2vt\3\2\2\2wy\7\17"+
		"\2\2xw\3\2\2\2xy\3\2\2\2yz\3\2\2\2z{\7\f\2\2{|\3\2\2\2|}\b\22\2\2}$\3"+
		"\2\2\2\b\2^ehtx\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
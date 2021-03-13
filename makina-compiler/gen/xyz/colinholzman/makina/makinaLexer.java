// Generated from D:/Colin/My Documents/makina/makina-compiler/src\makina.g4 by ANTLR 4.9.1
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
		T__9=10, T__10=11, T__11=12, T__12=13, ID=14, WHITESPACE=15, COMMENT=16;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "ID", "WHITESPACE", "COMMENT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'machine'", "';'", "'initial'", "'state'", "'{'", "'}'", "':'", 
			"'entry'", "'exit'", "'on'", "'('", "')'", "'->'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, "ID", "WHITESPACE", "COMMENT"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\22z\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3"+
		"\n\3\n\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\16\3\17\3\17"+
		"\7\17Y\n\17\f\17\16\17\\\13\17\3\17\3\17\6\17`\n\17\r\17\16\17a\3\17\5"+
		"\17e\n\17\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\7\21o\n\21\f\21\16\21"+
		"r\13\21\3\21\5\21u\n\21\3\21\3\21\3\21\3\21\2\2\22\3\3\5\4\7\5\t\6\13"+
		"\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22\3\2\7\5\2"+
		"C\\aac|\6\2\62;C\\aac|\3\2bb\5\2\13\f\16\17\"\"\4\2\f\f\17\17\2~\2\3\3"+
		"\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2"+
		"\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3"+
		"\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\3#\3\2\2\2\5"+
		"+\3\2\2\2\7-\3\2\2\2\t\65\3\2\2\2\13;\3\2\2\2\r=\3\2\2\2\17?\3\2\2\2\21"+
		"A\3\2\2\2\23G\3\2\2\2\25L\3\2\2\2\27O\3\2\2\2\31Q\3\2\2\2\33S\3\2\2\2"+
		"\35d\3\2\2\2\37f\3\2\2\2!j\3\2\2\2#$\7o\2\2$%\7c\2\2%&\7e\2\2&\'\7j\2"+
		"\2\'(\7k\2\2()\7p\2\2)*\7g\2\2*\4\3\2\2\2+,\7=\2\2,\6\3\2\2\2-.\7k\2\2"+
		"./\7p\2\2/\60\7k\2\2\60\61\7v\2\2\61\62\7k\2\2\62\63\7c\2\2\63\64\7n\2"+
		"\2\64\b\3\2\2\2\65\66\7u\2\2\66\67\7v\2\2\678\7c\2\289\7v\2\29:\7g\2\2"+
		":\n\3\2\2\2;<\7}\2\2<\f\3\2\2\2=>\7\177\2\2>\16\3\2\2\2?@\7<\2\2@\20\3"+
		"\2\2\2AB\7g\2\2BC\7p\2\2CD\7v\2\2DE\7t\2\2EF\7{\2\2F\22\3\2\2\2GH\7g\2"+
		"\2HI\7z\2\2IJ\7k\2\2JK\7v\2\2K\24\3\2\2\2LM\7q\2\2MN\7p\2\2N\26\3\2\2"+
		"\2OP\7*\2\2P\30\3\2\2\2QR\7+\2\2R\32\3\2\2\2ST\7/\2\2TU\7@\2\2U\34\3\2"+
		"\2\2VZ\t\2\2\2WY\t\3\2\2XW\3\2\2\2Y\\\3\2\2\2ZX\3\2\2\2Z[\3\2\2\2[e\3"+
		"\2\2\2\\Z\3\2\2\2]_\7b\2\2^`\n\4\2\2_^\3\2\2\2`a\3\2\2\2a_\3\2\2\2ab\3"+
		"\2\2\2bc\3\2\2\2ce\7b\2\2dV\3\2\2\2d]\3\2\2\2e\36\3\2\2\2fg\t\5\2\2gh"+
		"\3\2\2\2hi\b\20\2\2i \3\2\2\2jk\7\61\2\2kl\7\61\2\2lp\3\2\2\2mo\n\6\2"+
		"\2nm\3\2\2\2or\3\2\2\2pn\3\2\2\2pq\3\2\2\2qt\3\2\2\2rp\3\2\2\2su\7\17"+
		"\2\2ts\3\2\2\2tu\3\2\2\2uv\3\2\2\2vw\7\f\2\2wx\3\2\2\2xy\b\21\2\2y\"\3"+
		"\2\2\2\b\2Zadpt\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
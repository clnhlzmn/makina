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
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, ID=16, WHITESPACE=17, 
		COMMENT=18;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "ID", "WHITESPACE", 
			"COMMENT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'machine'", "';'", "'initial'", "'final'", "'state'", "'{'", "'}'", 
			"'.'", "'entry'", "'exit'", "'on'", "'('", "')'", "'->'", "'-->'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, "ID", "WHITESPACE", "COMMENT"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\24\u0088\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\7"+
		"\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13"+
		"\3\f\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\21"+
		"\3\21\7\21g\n\21\f\21\16\21j\13\21\3\21\3\21\6\21n\n\21\r\21\16\21o\3"+
		"\21\5\21s\n\21\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\7\23}\n\23\f\23"+
		"\16\23\u0080\13\23\3\23\5\23\u0083\n\23\3\23\3\23\3\23\3\23\2\2\24\3\3"+
		"\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21"+
		"!\22#\23%\24\3\2\7\5\2C\\aac|\6\2\62;C\\aac|\3\2bb\5\2\13\f\16\17\"\""+
		"\4\2\f\f\17\17\2\u008c\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2"+
		"\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25"+
		"\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2"+
		"\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\3\'\3\2\2\2\5/\3\2\2\2\7\61\3\2"+
		"\2\2\t9\3\2\2\2\13?\3\2\2\2\rE\3\2\2\2\17G\3\2\2\2\21I\3\2\2\2\23K\3\2"+
		"\2\2\25Q\3\2\2\2\27V\3\2\2\2\31Y\3\2\2\2\33[\3\2\2\2\35]\3\2\2\2\37`\3"+
		"\2\2\2!r\3\2\2\2#t\3\2\2\2%x\3\2\2\2\'(\7o\2\2()\7c\2\2)*\7e\2\2*+\7j"+
		"\2\2+,\7k\2\2,-\7p\2\2-.\7g\2\2.\4\3\2\2\2/\60\7=\2\2\60\6\3\2\2\2\61"+
		"\62\7k\2\2\62\63\7p\2\2\63\64\7k\2\2\64\65\7v\2\2\65\66\7k\2\2\66\67\7"+
		"c\2\2\678\7n\2\28\b\3\2\2\29:\7h\2\2:;\7k\2\2;<\7p\2\2<=\7c\2\2=>\7n\2"+
		"\2>\n\3\2\2\2?@\7u\2\2@A\7v\2\2AB\7c\2\2BC\7v\2\2CD\7g\2\2D\f\3\2\2\2"+
		"EF\7}\2\2F\16\3\2\2\2GH\7\177\2\2H\20\3\2\2\2IJ\7\60\2\2J\22\3\2\2\2K"+
		"L\7g\2\2LM\7p\2\2MN\7v\2\2NO\7t\2\2OP\7{\2\2P\24\3\2\2\2QR\7g\2\2RS\7"+
		"z\2\2ST\7k\2\2TU\7v\2\2U\26\3\2\2\2VW\7q\2\2WX\7p\2\2X\30\3\2\2\2YZ\7"+
		"*\2\2Z\32\3\2\2\2[\\\7+\2\2\\\34\3\2\2\2]^\7/\2\2^_\7@\2\2_\36\3\2\2\2"+
		"`a\7/\2\2ab\7/\2\2bc\7@\2\2c \3\2\2\2dh\t\2\2\2eg\t\3\2\2fe\3\2\2\2gj"+
		"\3\2\2\2hf\3\2\2\2hi\3\2\2\2is\3\2\2\2jh\3\2\2\2km\7b\2\2ln\n\4\2\2ml"+
		"\3\2\2\2no\3\2\2\2om\3\2\2\2op\3\2\2\2pq\3\2\2\2qs\7b\2\2rd\3\2\2\2rk"+
		"\3\2\2\2s\"\3\2\2\2tu\t\5\2\2uv\3\2\2\2vw\b\22\2\2w$\3\2\2\2xy\7\61\2"+
		"\2yz\7\61\2\2z~\3\2\2\2{}\n\6\2\2|{\3\2\2\2}\u0080\3\2\2\2~|\3\2\2\2~"+
		"\177\3\2\2\2\177\u0082\3\2\2\2\u0080~\3\2\2\2\u0081\u0083\7\17\2\2\u0082"+
		"\u0081\3\2\2\2\u0082\u0083\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u0085\7\f"+
		"\2\2\u0085\u0086\3\2\2\2\u0086\u0087\b\23\2\2\u0087&\3\2\2\2\b\2hor~\u0082"+
		"\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
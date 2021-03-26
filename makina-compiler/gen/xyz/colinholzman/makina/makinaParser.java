// Generated from /Users/colinholzman/makina/makina-compiler/src/makina.g4 by ANTLR 4.9.1
package xyz.colinholzman.makina;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class makinaParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, ID=15, WHITESPACE=16, 
		COMMENT=17;
	public static final int
		RULE_file = 0, RULE_state = 1, RULE_id = 2, RULE_handler = 3, RULE_action = 4, 
		RULE_guard = 5, RULE_target = 6;
	private static String[] makeRuleNames() {
		return new String[] {
			"file", "state", "id", "handler", "action", "guard", "target"
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

	@Override
	public String getGrammarFileName() { return "makina.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public makinaParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class FileContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(makinaParser.ID, 0); }
		public TerminalNode EOF() { return getToken(makinaParser.EOF, 0); }
		public List<StateContext> state() {
			return getRuleContexts(StateContext.class);
		}
		public StateContext state(int i) {
			return getRuleContext(StateContext.class,i);
		}
		public FileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_file; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof makinaListener ) ((makinaListener)listener).enterFile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof makinaListener ) ((makinaListener)listener).exitFile(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof makinaVisitor ) return ((makinaVisitor<? extends T>)visitor).visitFile(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FileContext file() throws RecognitionException {
		FileContext _localctx = new FileContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_file);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(14);
			match(T__0);
			setState(15);
			match(ID);
			setState(16);
			match(T__1);
			setState(20);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2 || _la==T__3) {
				{
				{
				setState(17);
				state();
				}
				}
				setState(22);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(23);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StateContext extends ParserRuleContext {
		public Token initial;
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public List<HandlerContext> handler() {
			return getRuleContexts(HandlerContext.class);
		}
		public HandlerContext handler(int i) {
			return getRuleContext(HandlerContext.class,i);
		}
		public List<StateContext> state() {
			return getRuleContexts(StateContext.class);
		}
		public StateContext state(int i) {
			return getRuleContext(StateContext.class,i);
		}
		public StateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_state; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof makinaListener ) ((makinaListener)listener).enterState(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof makinaListener ) ((makinaListener)listener).exitState(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof makinaVisitor ) return ((makinaVisitor<? extends T>)visitor).visitState(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StateContext state() throws RecognitionException {
		StateContext _localctx = new StateContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_state);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(26);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(25);
				((StateContext)_localctx).initial = match(T__2);
				}
			}

			setState(28);
			match(T__3);
			setState(29);
			id();
			setState(30);
			match(T__4);
			setState(35);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__7) | (1L << T__8) | (1L << T__9))) != 0)) {
				{
				setState(33);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__7:
				case T__8:
				case T__9:
					{
					setState(31);
					handler();
					}
					break;
				case T__2:
				case T__3:
					{
					setState(32);
					state();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(37);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(38);
			match(T__5);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdContext extends ParserRuleContext {
		public Token root;
		public List<TerminalNode> ID() { return getTokens(makinaParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(makinaParser.ID, i);
		}
		public IdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_id; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof makinaListener ) ((makinaListener)listener).enterId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof makinaListener ) ((makinaListener)listener).exitId(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof makinaVisitor ) return ((makinaVisitor<? extends T>)visitor).visitId(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdContext id() throws RecognitionException {
		IdContext _localctx = new IdContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_id);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(41);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(40);
				((IdContext)_localctx).root = match(T__6);
				}
			}

			setState(43);
			match(ID);
			setState(48);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__6) {
				{
				{
				setState(44);
				match(T__6);
				setState(45);
				match(ID);
				}
				}
				setState(50);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class HandlerContext extends ParserRuleContext {
		public HandlerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_handler; }
	 
		public HandlerContext() { }
		public void copyFrom(HandlerContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class EntryHandlerContext extends HandlerContext {
		public ActionContext action() {
			return getRuleContext(ActionContext.class,0);
		}
		public EntryHandlerContext(HandlerContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof makinaListener ) ((makinaListener)listener).enterEntryHandler(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof makinaListener ) ((makinaListener)listener).exitEntryHandler(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof makinaVisitor ) return ((makinaVisitor<? extends T>)visitor).visitEntryHandler(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExitHandlerContext extends HandlerContext {
		public ActionContext action() {
			return getRuleContext(ActionContext.class,0);
		}
		public ExitHandlerContext(HandlerContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof makinaListener ) ((makinaListener)listener).enterExitHandler(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof makinaListener ) ((makinaListener)listener).exitExitHandler(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof makinaVisitor ) return ((makinaVisitor<? extends T>)visitor).visitExitHandler(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EventHandlerContext extends HandlerContext {
		public TerminalNode ID() { return getToken(makinaParser.ID, 0); }
		public GuardContext guard() {
			return getRuleContext(GuardContext.class,0);
		}
		public ActionContext action() {
			return getRuleContext(ActionContext.class,0);
		}
		public TargetContext target() {
			return getRuleContext(TargetContext.class,0);
		}
		public EventHandlerContext(HandlerContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof makinaListener ) ((makinaListener)listener).enterEventHandler(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof makinaListener ) ((makinaListener)listener).exitEventHandler(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof makinaVisitor ) return ((makinaVisitor<? extends T>)visitor).visitEventHandler(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HandlerContext handler() throws RecognitionException {
		HandlerContext _localctx = new HandlerContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_handler);
		int _la;
		try {
			setState(71);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__7:
				_localctx = new EntryHandlerContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(51);
				match(T__7);
				setState(52);
				action();
				setState(53);
				match(T__1);
				}
				break;
			case T__8:
				_localctx = new ExitHandlerContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(55);
				match(T__8);
				setState(56);
				action();
				setState(57);
				match(T__1);
				}
				break;
			case T__9:
				_localctx = new EventHandlerContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(59);
				match(T__9);
				setState(60);
				match(ID);
				setState(62);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__10) {
					{
					setState(61);
					guard();
					}
				}

				setState(65);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(64);
					action();
					}
				}

				setState(68);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__12 || _la==T__13) {
					{
					setState(67);
					target();
					}
				}

				setState(70);
				match(T__1);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ActionContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(makinaParser.ID, 0); }
		public ActionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_action; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof makinaListener ) ((makinaListener)listener).enterAction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof makinaListener ) ((makinaListener)listener).exitAction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof makinaVisitor ) return ((makinaVisitor<? extends T>)visitor).visitAction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ActionContext action() throws RecognitionException {
		ActionContext _localctx = new ActionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_action);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GuardContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(makinaParser.ID, 0); }
		public GuardContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_guard; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof makinaListener ) ((makinaListener)listener).enterGuard(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof makinaListener ) ((makinaListener)listener).exitGuard(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof makinaVisitor ) return ((makinaVisitor<? extends T>)visitor).visitGuard(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GuardContext guard() throws RecognitionException {
		GuardContext _localctx = new GuardContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_guard);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			match(T__10);
			setState(76);
			match(ID);
			setState(77);
			match(T__11);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TargetContext extends ParserRuleContext {
		public TargetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_target; }
	 
		public TargetContext() { }
		public void copyFrom(TargetContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ExternalTransitionContext extends TargetContext {
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public ExternalTransitionContext(TargetContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof makinaListener ) ((makinaListener)listener).enterExternalTransition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof makinaListener ) ((makinaListener)listener).exitExternalTransition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof makinaVisitor ) return ((makinaVisitor<? extends T>)visitor).visitExternalTransition(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LocalTransitionContext extends TargetContext {
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public LocalTransitionContext(TargetContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof makinaListener ) ((makinaListener)listener).enterLocalTransition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof makinaListener ) ((makinaListener)listener).exitLocalTransition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof makinaVisitor ) return ((makinaVisitor<? extends T>)visitor).visitLocalTransition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TargetContext target() throws RecognitionException {
		TargetContext _localctx = new TargetContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_target);
		try {
			setState(83);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__12:
				_localctx = new ExternalTransitionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(79);
				match(T__12);
				setState(80);
				id();
				}
				break;
			case T__13:
				_localctx = new LocalTransitionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(81);
				match(T__13);
				setState(82);
				id();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\23X\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\3\2\3\2\3\2\3\2\7\2\25\n\2"+
		"\f\2\16\2\30\13\2\3\2\3\2\3\3\5\3\35\n\3\3\3\3\3\3\3\3\3\3\3\7\3$\n\3"+
		"\f\3\16\3\'\13\3\3\3\3\3\3\4\5\4,\n\4\3\4\3\4\3\4\7\4\61\n\4\f\4\16\4"+
		"\64\13\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5A\n\5\3\5\5\5"+
		"D\n\5\3\5\5\5G\n\5\3\5\5\5J\n\5\3\6\3\6\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3"+
		"\b\5\bV\n\b\3\b\2\2\t\2\4\6\b\n\f\16\2\2\2\\\2\20\3\2\2\2\4\34\3\2\2\2"+
		"\6+\3\2\2\2\bI\3\2\2\2\nK\3\2\2\2\fM\3\2\2\2\16U\3\2\2\2\20\21\7\3\2\2"+
		"\21\22\7\21\2\2\22\26\7\4\2\2\23\25\5\4\3\2\24\23\3\2\2\2\25\30\3\2\2"+
		"\2\26\24\3\2\2\2\26\27\3\2\2\2\27\31\3\2\2\2\30\26\3\2\2\2\31\32\7\2\2"+
		"\3\32\3\3\2\2\2\33\35\7\5\2\2\34\33\3\2\2\2\34\35\3\2\2\2\35\36\3\2\2"+
		"\2\36\37\7\6\2\2\37 \5\6\4\2 %\7\7\2\2!$\5\b\5\2\"$\5\4\3\2#!\3\2\2\2"+
		"#\"\3\2\2\2$\'\3\2\2\2%#\3\2\2\2%&\3\2\2\2&(\3\2\2\2\'%\3\2\2\2()\7\b"+
		"\2\2)\5\3\2\2\2*,\7\t\2\2+*\3\2\2\2+,\3\2\2\2,-\3\2\2\2-\62\7\21\2\2."+
		"/\7\t\2\2/\61\7\21\2\2\60.\3\2\2\2\61\64\3\2\2\2\62\60\3\2\2\2\62\63\3"+
		"\2\2\2\63\7\3\2\2\2\64\62\3\2\2\2\65\66\7\n\2\2\66\67\5\n\6\2\678\7\4"+
		"\2\28J\3\2\2\29:\7\13\2\2:;\5\n\6\2;<\7\4\2\2<J\3\2\2\2=>\7\f\2\2>@\7"+
		"\21\2\2?A\5\f\7\2@?\3\2\2\2@A\3\2\2\2AC\3\2\2\2BD\5\n\6\2CB\3\2\2\2CD"+
		"\3\2\2\2DF\3\2\2\2EG\5\16\b\2FE\3\2\2\2FG\3\2\2\2GH\3\2\2\2HJ\7\4\2\2"+
		"I\65\3\2\2\2I9\3\2\2\2I=\3\2\2\2J\t\3\2\2\2KL\7\21\2\2L\13\3\2\2\2MN\7"+
		"\r\2\2NO\7\21\2\2OP\7\16\2\2P\r\3\2\2\2QR\7\17\2\2RV\5\6\4\2ST\7\20\2"+
		"\2TV\5\6\4\2UQ\3\2\2\2US\3\2\2\2V\17\3\2\2\2\r\26\34#%+\62@CFIU";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
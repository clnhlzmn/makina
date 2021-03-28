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
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, ID=16, WHITESPACE=17, 
		COMMENT=18;
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
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4))) != 0)) {
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
		public Token final_;
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
			setState(31);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
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

				}
				break;
			case 2:
				{
				setState(29);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__3) {
					{
					setState(28);
					((StateContext)_localctx).final_ = match(T__3);
					}
				}

				}
				break;
			}
			setState(33);
			match(T__4);
			setState(34);
			id();
			setState(35);
			match(T__5);
			setState(40);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__8) | (1L << T__9) | (1L << T__10))) != 0)) {
				{
				setState(38);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__8:
				case T__9:
				case T__10:
					{
					setState(36);
					handler();
					}
					break;
				case T__2:
				case T__3:
				case T__4:
					{
					setState(37);
					state();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(42);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(43);
			match(T__6);
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
			setState(46);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__7) {
				{
				setState(45);
				((IdContext)_localctx).root = match(T__7);
				}
			}

			setState(48);
			match(ID);
			setState(53);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__7) {
				{
				{
				setState(49);
				match(T__7);
				setState(50);
				match(ID);
				}
				}
				setState(55);
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
			setState(76);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__8:
				_localctx = new EntryHandlerContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(56);
				match(T__8);
				setState(57);
				action();
				setState(58);
				match(T__1);
				}
				break;
			case T__9:
				_localctx = new ExitHandlerContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(60);
				match(T__9);
				setState(61);
				action();
				setState(62);
				match(T__1);
				}
				break;
			case T__10:
				_localctx = new EventHandlerContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(64);
				match(T__10);
				setState(65);
				match(ID);
				setState(67);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__11) {
					{
					setState(66);
					guard();
					}
				}

				setState(70);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(69);
					action();
					}
				}

				setState(73);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__13 || _la==T__14) {
					{
					setState(72);
					target();
					}
				}

				setState(75);
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
			setState(78);
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
			setState(80);
			match(T__11);
			setState(81);
			match(ID);
			setState(82);
			match(T__12);
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
	public static class DefaultTransitionContext extends TargetContext {
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public DefaultTransitionContext(TargetContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof makinaListener ) ((makinaListener)listener).enterDefaultTransition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof makinaListener ) ((makinaListener)listener).exitDefaultTransition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof makinaVisitor ) return ((makinaVisitor<? extends T>)visitor).visitDefaultTransition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TargetContext target() throws RecognitionException {
		TargetContext _localctx = new TargetContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_target);
		try {
			setState(88);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__13:
				_localctx = new DefaultTransitionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(84);
				match(T__13);
				setState(85);
				id();
				}
				break;
			case T__14:
				_localctx = new ExternalTransitionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(86);
				match(T__14);
				setState(87);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\24]\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\3\2\3\2\3\2\3\2\7\2\25\n\2"+
		"\f\2\16\2\30\13\2\3\2\3\2\3\3\5\3\35\n\3\3\3\5\3 \n\3\5\3\"\n\3\3\3\3"+
		"\3\3\3\3\3\3\3\7\3)\n\3\f\3\16\3,\13\3\3\3\3\3\3\4\5\4\61\n\4\3\4\3\4"+
		"\3\4\7\4\66\n\4\f\4\16\49\13\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\5\5F\n\5\3\5\5\5I\n\5\3\5\5\5L\n\5\3\5\5\5O\n\5\3\6\3\6\3\7\3\7\3"+
		"\7\3\7\3\b\3\b\3\b\3\b\5\b[\n\b\3\b\2\2\t\2\4\6\b\n\f\16\2\2\2c\2\20\3"+
		"\2\2\2\4!\3\2\2\2\6\60\3\2\2\2\bN\3\2\2\2\nP\3\2\2\2\fR\3\2\2\2\16Z\3"+
		"\2\2\2\20\21\7\3\2\2\21\22\7\22\2\2\22\26\7\4\2\2\23\25\5\4\3\2\24\23"+
		"\3\2\2\2\25\30\3\2\2\2\26\24\3\2\2\2\26\27\3\2\2\2\27\31\3\2\2\2\30\26"+
		"\3\2\2\2\31\32\7\2\2\3\32\3\3\2\2\2\33\35\7\5\2\2\34\33\3\2\2\2\34\35"+
		"\3\2\2\2\35\"\3\2\2\2\36 \7\6\2\2\37\36\3\2\2\2\37 \3\2\2\2 \"\3\2\2\2"+
		"!\34\3\2\2\2!\37\3\2\2\2\"#\3\2\2\2#$\7\7\2\2$%\5\6\4\2%*\7\b\2\2&)\5"+
		"\b\5\2\')\5\4\3\2(&\3\2\2\2(\'\3\2\2\2),\3\2\2\2*(\3\2\2\2*+\3\2\2\2+"+
		"-\3\2\2\2,*\3\2\2\2-.\7\t\2\2.\5\3\2\2\2/\61\7\n\2\2\60/\3\2\2\2\60\61"+
		"\3\2\2\2\61\62\3\2\2\2\62\67\7\22\2\2\63\64\7\n\2\2\64\66\7\22\2\2\65"+
		"\63\3\2\2\2\669\3\2\2\2\67\65\3\2\2\2\678\3\2\2\28\7\3\2\2\29\67\3\2\2"+
		"\2:;\7\13\2\2;<\5\n\6\2<=\7\4\2\2=O\3\2\2\2>?\7\f\2\2?@\5\n\6\2@A\7\4"+
		"\2\2AO\3\2\2\2BC\7\r\2\2CE\7\22\2\2DF\5\f\7\2ED\3\2\2\2EF\3\2\2\2FH\3"+
		"\2\2\2GI\5\n\6\2HG\3\2\2\2HI\3\2\2\2IK\3\2\2\2JL\5\16\b\2KJ\3\2\2\2KL"+
		"\3\2\2\2LM\3\2\2\2MO\7\4\2\2N:\3\2\2\2N>\3\2\2\2NB\3\2\2\2O\t\3\2\2\2"+
		"PQ\7\22\2\2Q\13\3\2\2\2RS\7\16\2\2ST\7\22\2\2TU\7\17\2\2U\r\3\2\2\2VW"+
		"\7\20\2\2W[\5\6\4\2XY\7\21\2\2Y[\5\6\4\2ZV\3\2\2\2ZX\3\2\2\2[\17\3\2\2"+
		"\2\17\26\34\37!(*\60\67EHKNZ";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
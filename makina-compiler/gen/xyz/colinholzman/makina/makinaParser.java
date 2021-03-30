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
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, ID=17, 
		WHITESPACE=18, COMMENT=19;
	public static final int
		RULE_file = 0, RULE_state = 1, RULE_stateType = 2, RULE_id = 3, RULE_handler = 4, 
		RULE_action = 5, RULE_guard = 6, RULE_target = 7;
	private static String[] makeRuleNames() {
		return new String[] {
			"file", "state", "stateType", "id", "handler", "action", "guard", "target"
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
			setState(16);
			match(T__0);
			setState(17);
			match(ID);
			setState(18);
			match(T__1);
			setState(22);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7))) != 0)) {
				{
				{
				setState(19);
				state();
				}
				}
				setState(24);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(25);
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
		public StateTypeContext stateType() {
			return getRuleContext(StateTypeContext.class,0);
		}
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
			setState(27);
			stateType();
			setState(28);
			id();
			setState(29);
			match(T__2);
			setState(34);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__9) | (1L << T__10) | (1L << T__11))) != 0)) {
				{
				setState(32);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__9:
				case T__10:
				case T__11:
					{
					setState(30);
					handler();
					}
					break;
				case T__4:
				case T__5:
				case T__6:
				case T__7:
					{
					setState(31);
					state();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(36);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(37);
			match(T__3);
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

	public static class StateTypeContext extends ParserRuleContext {
		public StateTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stateType; }
	 
		public StateTypeContext() { }
		public void copyFrom(StateTypeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ParallelTypeContext extends StateTypeContext {
		public Token initial;
		public ParallelTypeContext(StateTypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof makinaListener ) ((makinaListener)listener).enterParallelType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof makinaListener ) ((makinaListener)listener).exitParallelType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof makinaVisitor ) return ((makinaVisitor<? extends T>)visitor).visitParallelType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class InitialTypeContext extends StateTypeContext {
		public InitialTypeContext(StateTypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof makinaListener ) ((makinaListener)listener).enterInitialType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof makinaListener ) ((makinaListener)listener).exitInitialType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof makinaVisitor ) return ((makinaVisitor<? extends T>)visitor).visitInitialType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FinalTypeContext extends StateTypeContext {
		public FinalTypeContext(StateTypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof makinaListener ) ((makinaListener)listener).enterFinalType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof makinaListener ) ((makinaListener)listener).exitFinalType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof makinaVisitor ) return ((makinaVisitor<? extends T>)visitor).visitFinalType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DefaultTypeContext extends StateTypeContext {
		public DefaultTypeContext(StateTypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof makinaListener ) ((makinaListener)listener).enterDefaultType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof makinaListener ) ((makinaListener)listener).exitDefaultType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof makinaVisitor ) return ((makinaVisitor<? extends T>)visitor).visitDefaultType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StateTypeContext stateType() throws RecognitionException {
		StateTypeContext _localctx = new StateTypeContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_stateType);
		int _la;
		try {
			setState(55);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				_localctx = new InitialTypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(39);
				match(T__4);
				setState(41);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__5) {
					{
					setState(40);
					match(T__5);
					}
				}

				}
				break;
			case 2:
				_localctx = new ParallelTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(44);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__4) {
					{
					setState(43);
					((ParallelTypeContext)_localctx).initial = match(T__4);
					}
				}

				setState(46);
				match(T__6);
				setState(48);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__5) {
					{
					setState(47);
					match(T__5);
					}
				}

				}
				break;
			case 3:
				_localctx = new FinalTypeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(50);
				match(T__7);
				setState(52);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__5) {
					{
					setState(51);
					match(T__5);
					}
				}

				}
				break;
			case 4:
				_localctx = new DefaultTypeContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(54);
				match(T__5);
				}
				break;
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
		enterRule(_localctx, 6, RULE_id);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(58);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__8) {
				{
				setState(57);
				((IdContext)_localctx).root = match(T__8);
				}
			}

			setState(60);
			match(ID);
			setState(65);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__8) {
				{
				{
				setState(61);
				match(T__8);
				setState(62);
				match(ID);
				}
				}
				setState(67);
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
		enterRule(_localctx, 8, RULE_handler);
		int _la;
		try {
			setState(88);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__9:
				_localctx = new EntryHandlerContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(68);
				match(T__9);
				setState(69);
				action();
				setState(70);
				match(T__1);
				}
				break;
			case T__10:
				_localctx = new ExitHandlerContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(72);
				match(T__10);
				setState(73);
				action();
				setState(74);
				match(T__1);
				}
				break;
			case T__11:
				_localctx = new EventHandlerContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(76);
				match(T__11);
				setState(77);
				match(ID);
				setState(79);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__12) {
					{
					setState(78);
					guard();
					}
				}

				setState(82);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(81);
					action();
					}
				}

				setState(85);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__14 || _la==T__15) {
					{
					setState(84);
					target();
					}
				}

				setState(87);
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
		enterRule(_localctx, 10, RULE_action);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
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
		enterRule(_localctx, 12, RULE_guard);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			match(T__12);
			setState(93);
			match(ID);
			setState(94);
			match(T__13);
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
		enterRule(_localctx, 14, RULE_target);
		try {
			setState(100);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__14:
				_localctx = new DefaultTransitionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(96);
				match(T__14);
				setState(97);
				id();
				}
				break;
			case T__15:
				_localctx = new ExternalTransitionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(98);
				match(T__15);
				setState(99);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\25i\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\3\2\3\2\3\2\3\2\7\2"+
		"\27\n\2\f\2\16\2\32\13\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\7\3#\n\3\f\3\16\3"+
		"&\13\3\3\3\3\3\3\4\3\4\5\4,\n\4\3\4\5\4/\n\4\3\4\3\4\5\4\63\n\4\3\4\3"+
		"\4\5\4\67\n\4\3\4\5\4:\n\4\3\5\5\5=\n\5\3\5\3\5\3\5\7\5B\n\5\f\5\16\5"+
		"E\13\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6R\n\6\3\6\5\6U\n"+
		"\6\3\6\5\6X\n\6\3\6\5\6[\n\6\3\7\3\7\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\5"+
		"\tg\n\t\3\t\2\2\n\2\4\6\b\n\f\16\20\2\2\2r\2\22\3\2\2\2\4\35\3\2\2\2\6"+
		"9\3\2\2\2\b<\3\2\2\2\nZ\3\2\2\2\f\\\3\2\2\2\16^\3\2\2\2\20f\3\2\2\2\22"+
		"\23\7\3\2\2\23\24\7\23\2\2\24\30\7\4\2\2\25\27\5\4\3\2\26\25\3\2\2\2\27"+
		"\32\3\2\2\2\30\26\3\2\2\2\30\31\3\2\2\2\31\33\3\2\2\2\32\30\3\2\2\2\33"+
		"\34\7\2\2\3\34\3\3\2\2\2\35\36\5\6\4\2\36\37\5\b\5\2\37$\7\5\2\2 #\5\n"+
		"\6\2!#\5\4\3\2\" \3\2\2\2\"!\3\2\2\2#&\3\2\2\2$\"\3\2\2\2$%\3\2\2\2%\'"+
		"\3\2\2\2&$\3\2\2\2\'(\7\6\2\2(\5\3\2\2\2)+\7\7\2\2*,\7\b\2\2+*\3\2\2\2"+
		"+,\3\2\2\2,:\3\2\2\2-/\7\7\2\2.-\3\2\2\2./\3\2\2\2/\60\3\2\2\2\60\62\7"+
		"\t\2\2\61\63\7\b\2\2\62\61\3\2\2\2\62\63\3\2\2\2\63:\3\2\2\2\64\66\7\n"+
		"\2\2\65\67\7\b\2\2\66\65\3\2\2\2\66\67\3\2\2\2\67:\3\2\2\28:\7\b\2\29"+
		")\3\2\2\29.\3\2\2\29\64\3\2\2\298\3\2\2\2:\7\3\2\2\2;=\7\13\2\2<;\3\2"+
		"\2\2<=\3\2\2\2=>\3\2\2\2>C\7\23\2\2?@\7\13\2\2@B\7\23\2\2A?\3\2\2\2BE"+
		"\3\2\2\2CA\3\2\2\2CD\3\2\2\2D\t\3\2\2\2EC\3\2\2\2FG\7\f\2\2GH\5\f\7\2"+
		"HI\7\4\2\2I[\3\2\2\2JK\7\r\2\2KL\5\f\7\2LM\7\4\2\2M[\3\2\2\2NO\7\16\2"+
		"\2OQ\7\23\2\2PR\5\16\b\2QP\3\2\2\2QR\3\2\2\2RT\3\2\2\2SU\5\f\7\2TS\3\2"+
		"\2\2TU\3\2\2\2UW\3\2\2\2VX\5\20\t\2WV\3\2\2\2WX\3\2\2\2XY\3\2\2\2Y[\7"+
		"\4\2\2ZF\3\2\2\2ZJ\3\2\2\2ZN\3\2\2\2[\13\3\2\2\2\\]\7\23\2\2]\r\3\2\2"+
		"\2^_\7\17\2\2_`\7\23\2\2`a\7\20\2\2a\17\3\2\2\2bc\7\21\2\2cg\5\b\5\2d"+
		"e\7\22\2\2eg\5\b\5\2fb\3\2\2\2fd\3\2\2\2g\21\3\2\2\2\21\30\"$+.\62\66"+
		"9<CQTWZf";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
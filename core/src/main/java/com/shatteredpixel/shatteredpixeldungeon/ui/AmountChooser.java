package com.shatteredpixel.shatteredpixeldungeon.ui;

import com.shatteredpixel.shatteredpixeldungeon.messages.Messages;
import com.shatteredpixel.shatteredpixeldungeon.scenes.PixelScene;
import com.watabou.noosa.ColorBlock;
import com.watabou.noosa.ui.Component;
import com.watabou.utils.Callback;

public class AmountChooser extends Component {
	private static final int CONFIG_BTNCOLOR		= 0xFF2D2D2D;
	private int num;
	private final int FONT_SIZE = 9;
	private int size;

	private String label_txt;
	private RenderedTextBlock label;
	private Button less;
	private RenderedTextBlock amount;
	private Button more;
	private Callback callback;
	public AmountChooser(String text, int initial_num, int size){
		this.label_txt = text;
		this.num = initial_num;
		this.size = size;
	}

	public void set(int num){
		this.num = num;
		amount.text( String.valueOf(num) );
	}

	public int get(){return num;}

	public void setCallback(Callback func)
	{
		callback = func;
	}

	@Override
	protected void createChildren() {
		super.createChildren();

		label = PixelScene.renderTextBlock(FONT_SIZE );
		add(label);

		less = new Button(){
			private ColorBlock bg;
			private RenderedTextBlock text;

			@Override
			protected void onClick() {
				super.onClick();

				if(num>1) num--;
				amount.text( String.valueOf(num) );

				if(callback!=null) callback.call();
			}

			@Override
			protected void createChildren() {
				super.createChildren();

				bg = new ColorBlock(1,1, CONFIG_BTNCOLOR);
				add(bg);

				text = PixelScene.renderTextBlock( "-", FONT_SIZE);
				//text.align(RenderedTextBlock.CENTER_ALIGN);
				add(text);
			}

			@Override
			protected void layout() {
				super.layout();

				bg.size(width, height);
				bg.y = y;
				bg.x = x;

				text.setPos( x + size/2 - FONT_SIZE/2, y + size/2 - FONT_SIZE/2);
			}
		};
		add(less);

		amount = PixelScene.renderTextBlock("1", FONT_SIZE );
		add(amount);

		more = new Button(){
			private ColorBlock bg;
			private RenderedTextBlock text;

			@Override
			protected void onClick() {
				super.onClick();

				if(num<Integer.MAX_VALUE) num++;
				amount.text( String.valueOf(num) );

				if(callback!=null) callback.call();
			}

			@Override
			protected void createChildren() {
				super.createChildren();

				bg = new ColorBlock(1,1, CONFIG_BTNCOLOR);
				add(bg);

				text = PixelScene.renderTextBlock( "+", FONT_SIZE);
				add(text);
			}

			@Override
			protected void layout() {
				super.layout();

				bg.size(width, height);
				bg.y = y;
				bg.x = x;

				text.setPos( x + size/2 - FONT_SIZE/2, y + size/2 - FONT_SIZE/2);
			}
		};
		add(more);
	}

	@Override
	protected void layout() {
		super.layout();

		label.text(label_txt);
		label.setPos(x,y);
		less.setRect( x+size*2, y, size, size );
		amount.text(String.valueOf(num));
		amount.setPos( x + size*3 + size/2 - FONT_SIZE/2, y + size/2 - FONT_SIZE/2);
		//amount.setSize(size/2, size/2);
		more.setRect( x + size*5, y, size, size);
	}
}
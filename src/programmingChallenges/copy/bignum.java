package programmingChallenges.copy;

class bignum
{
	static final int MAXDIGITS = 100;	/* maximum length bignum */
	static final int PLUS = 1;			/* positive sign bit */
	static final int MINUS = -1;		/* negative sign bit */
	char digits[];						/* represent the number */
	int signbit;						/* 1 if positive, -1 if negative */
	int lastdigit;						/* index of high-order digit */
	
	bignum()
	{
		digits = new char[MAXDIGITS];
		int_2_bignum(0);
	}
	
	void print_bignum()
	{
		int i;
		if(signbit == MINUS)
			System.out.printf("- ");
		for(i = lastdigit; i >= 0; i--)
			System.out.printf("%c",'0'+digits[i]);
		System.out.printf("\n");
	}
	
	void int_2_bignum(int s)
	{
		if(s>=0) signbit = PLUS;
		else signbit = MINUS;
		for(int i = 0; i < MAXDIGITS; i++)
			digits[i] = (char) 0;
		lastdigit = -1;
		int t = Math.abs(s);
		while(t > 0)
		{
			lastdigit++;
			digits[lastdigit] = (char) (t % 10);
			t /= 10;
		}
		if(s == 0)
			lastdigit = 0;
	}
	
	bignum add_bignum(bignum b)
	{
		int carry, i;
		bignum c = new bignum();
		if(signbit == b.signbit)
			c.signbit = signbit;
		else
		{
			if(signbit == MINUS)
			{
				signbit = PLUS;
				c = b.subtract_bignum(this);
				signbit = MINUS;
			}
			
			else
			{
				b.signbit = PLUS;
				c = this.subtract_bignum(b);
				b.signbit = MINUS; 
			}
			return c;
		}
		
		c.lastdigit = Math.max(lastdigit, b.lastdigit) + 1;
		carry = 0;
		
		for(i = 0; i <= c.lastdigit; i++)
		{
			c.digits[i] = (char) ((carry + digits[i] + b.digits[i]) % 10);
			carry = (carry + digits[i] + b.digits[i]) / 10;
		}
		
		c.zero_justify();
		
		return c;
	}
	
	bignum subtract_bignum(bignum b)
	{
		int borrow, v, i;
		bignum c = new bignum();
		if(signbit == MINUS || b.signbit == MINUS)
		{
			b.signbit = -b.signbit;
			c = add_bignum(b);
			b.signbit = -b.signbit;
			return c;
		}
		if(compare_bignum(b) == PLUS)
		{
			c = b.subtract_bignum(this);
			c.signbit = MINUS;
			return c;
		}
		c.lastdigit = Math.max(lastdigit, b.lastdigit);
		borrow = 0;
		for(i = 0; i <= c.lastdigit; i++)
		{
			v = digits[i] - borrow - b.digits[i];
			if(digits[i] > 0)
				borrow = 0;
			if(v < 0)
			{
				v = v + 10;
				borrow = 1;
			}
			c.digits[i] = (char) (v % 10);
		}
		c.zero_justify();
		return c;
	}
	
	int compare_bignum(bignum b)
	{
		int i;
		if(signbit == MINUS && b.signbit == PLUS) return PLUS;
		if(signbit == PLUS && b.signbit == MINUS) return MINUS;
		if(b.lastdigit > lastdigit) return PLUS * signbit;
		if(lastdigit > b.lastdigit) return MINUS * signbit;
		
		for(i = lastdigit; i >= 0; i--)
		{
			if(digits[i] > b.digits[i])
				return MINUS * signbit;
			if(b.digits[i] > digits[i])
				return PLUS * signbit;			
		}
		
		return 0;
	}
	
	void zero_justify()
	{
		while(lastdigit > 0 && digits[lastdigit] == 0)
			lastdigit--;
		if(lastdigit == 0 && digits[0] == 0)
			signbit = PLUS;					/* hack to avoid -0 */
	}
	
	void digit_shift(int d)
	{
		int i;
		
		if(lastdigit == 0 && digits[0] == 0)
			return;
		
		for(i = lastdigit; i >= 0; i--)
			digits[i+d] = digits[i];
		
		for(i = 0; i < d; i++)
			digits[i] = 0;
		
		lastdigit += d;
	}
	
	bignum multiply_bignum(bignum b)
	{
		bignum row = new bignum();
		bignum tmp = new bignum();
		bignum c = new bignum();
		int i,j;
		row.signbit = this.signbit;
		row.lastdigit = this.lastdigit;
		System.arraycopy(this.digits, 0, row.digits, 0, this.digits.length);
		for(i = 0; i <= b.lastdigit; i++)
		{
			for(j = 1; j <= b.digits[i]; j++)
			{
				tmp = c.add_bignum(row);
				c = tmp;
			}
			row.digit_shift(1);
		}
		c.signbit = signbit * b.signbit;
		c.zero_justify();
		
		return c;
	}
	
	bignum divide_bignum(bignum b)
	{
		bignum row = new bignum();
		bignum tmp = new bignum();
		bignum c = new bignum();
		int asign, bsign, i;
		
		c.signbit = signbit * b.signbit;
		asign = signbit;
		bsign = b.signbit;
		
		signbit = PLUS;
		b.signbit = PLUS;
		
		c.lastdigit = lastdigit;
		
		for(i = lastdigit; i >= 0; i--)
		{
			row.digit_shift(1);
			row.digits[0] = digits[i];
			c.digits[i] = 0;
			while(row.compare_bignum(b) != PLUS)
			{
				c.digits[i]++;
				tmp = row.subtract_bignum(b);
				row = tmp;
			}
		}
		
		c.zero_justify();
		
		signbit = asign;
		b.signbit = bsign;
		
		return c;
	}
}
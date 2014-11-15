
public class MyVector {
	
	// class fields
	private int dim;
	private int[] vectorElements;
	
	// constructor method 1
	public MyVector( int n ){
		/* initializes a new vector object have n dimentions
		 * takes argument int n*/
		
		this.dim = n; 
		
	}
	
	// constructor method 2
	public MyVector( int[] values ){
		/* initializes a vector object to have distinct components
		 * takes an array of int elements as arguement
		 */
		
		this.vectorElements = values;
		
	}
	
	// All mutator methods

	public int getDim() {
		return dim;
	}

	public int getElement( int i ) throws IndexOutOfBoundsException{
		// letting the caller know that an exception  maybe thrown
		if(this.vectorElements.length < i){
			System.out.println("Invalid Index!");
			throw new IndexOutOfBoundsException();
			}//throw an exception to catch later if we have invalid index
		
			return this.vectorElements[i];
		
	}
	
	public void setElement(int x, int i) throws IndexOutOfBoundsException {
		/* takes arguement index/ position of vector component, int i
		 * takes arguement number to be assigned to the position, int x
		 */
		
		// letting the caller know that an exception  maybe thrown
		if(this.vectorElements.length < i){
			System.out.println("Invalid Index!");
			throw new IndexOutOfBoundsException();
		}//throw an exception to catch later if we have invalid index
		
		this.vectorElements[i] = x;
		
	}
	
	public MyVector copy( MyVector v ){
		/* returns a copy of a MyVector element that passed to the method*/ 
		
		MyVector n = new MyVector( v.getDim() );
		n.vectorElements = v.vectorElements;
		
		return n;
		
	}
	
	public void scale(int a) {
		/* performs scalar multiplication on a vector
		 * takes an integer as an arguement
		 */
		
		int len = this.dim;
		
		for ( int i=0; i<len; i++){
			this.vectorElements[i] *= a;
		}
		
	}
	
	public void addTo1(MyVector v){
		/* adds the argument vector to this vector*/
		
		if (this.dim != v.dim ){
			System.out.println("llegal Operation!");
		}// Detects illegal operation (different vector dimensions)
		else{
			int len = this.dim;
			
			for ( int i=0; i<len; i++ ){
				this.vectorElements[i] += v.vectorElements[i];
			}
		}
		
	}
	
	public MyVector addTo2(MyVector v) throws ArithmeticException {
		
		// letting the caller know that an exception  maybe thrown
		if(this.dim != v.dim){
			System.out.println("Illegal operation!");
			throw new ArithmeticException(); 
		}// throw exception if dimensions are not the same
		
		int len = this.dim;
		int num; //placeholder variable
		MyVector n = new MyVector( len ); // new object of class MyVector that will be returned 
		
		// for loop individually adds each dimensions of the vector and sets it to 
		// the proper index of the new array 
		for (int i=0; i<len; i++ ){
			num = this.vectorElements[i] + v.getElement(i);
			n.setElement(num, i);
		}
		
		return n;
	}
	
	public String toString(){
		
		/* returns a string of the dimensions of this vector*/
		
		String vecStr;
		String c = ""; //initializing to empty string
		
		for ( int i=0; i<this.dim; i++){
			c +=  this.vectorElements[i] + " ";
			// automatic type conversation
		}
		
		return c;
		
	}
		
}

package pfg.uem.biocon.lazylist;

import java.util.ArrayList;

import pfg.uem.biocon.R;
import pfg.uem.biocon.webservice.Annotation_CLEiM;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.DataSetObserver;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ImageAdapterView  extends BaseAdapter {
    private Context mContext;
 
    private String TAG = getClass().getSimpleName();
    
    private ArrayList<Annotation_CLEiM> annotations;
    
//    private int posicion=0;
    
    private Activity activity;
    private static LayoutInflater inflater=null;
    private Options options;
    public ImageLoader imageLoader;
    
    
    
    
    public ImageAdapterView(Context c, Activity a, ArrayList<Annotation_CLEiM> ranking) {
    	//Log.d(this.getClass().getSimpleName(),"Creador ");
    	mContext = c;
    	
    	options = new BitmapFactory.Options();
		options.inSampleSize = 6;
		
		activity = a;
		
		
		
		annotations = ranking;
//    	imageLoader=new ImageLoader(c.getApplicationContext());
    	
        inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        imageLoader=new ImageLoader(c);
        
        imageLoader = new ImageLoader(activity.getApplicationContext());
        
        
    }



	/* (non-Javadoc)
	 * @see android.widget.BaseAdapter#areAllItemsEnabled()
	 */
	@Override
	public boolean areAllItemsEnabled() {
		// TODO Auto-generated method stub
		return super.areAllItemsEnabled();
	}



	/* (non-Javadoc)
	 * @see android.widget.BaseAdapter#getDropDownView(int, android.view.View, android.view.ViewGroup)
	 */
	@Override
	public View getDropDownView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		return super.getDropDownView(position, convertView, parent);
	}



	/* (non-Javadoc)
	 * @see android.widget.BaseAdapter#getItemViewType(int)
	 */
	@Override
	public int getItemViewType(int position) {
		// TODO Auto-generated method stub
		return super.getItemViewType(position);
	}



	/* (non-Javadoc)
	 * @see android.widget.BaseAdapter#getViewTypeCount()
	 */
	@Override
	public int getViewTypeCount() {
		// TODO Auto-generated method stub
		return super.getViewTypeCount();
	}



	/* (non-Javadoc)
	 * @see android.widget.BaseAdapter#hasStableIds()
	 */
	@Override
	public boolean hasStableIds() {
		// TODO Auto-generated method stub
		return super.hasStableIds();
	}



	/* (non-Javadoc)
	 * @see android.widget.BaseAdapter#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return super.isEmpty();
	}



	/* (non-Javadoc)
	 * @see android.widget.BaseAdapter#notifyDataSetChanged()
	 */
	@Override
	public void notifyDataSetChanged() {
		// TODO Auto-generated method stub
		super.notifyDataSetChanged();
	}



	/* (non-Javadoc)
	 * @see android.widget.BaseAdapter#notifyDataSetInvalidated()
	 */
	@Override
	public void notifyDataSetInvalidated() {
		// TODO Auto-generated method stub
		super.notifyDataSetInvalidated();
	}



	/* (non-Javadoc)
	 * @see android.widget.BaseAdapter#registerDataSetObserver(android.database.DataSetObserver)
	 */
	@Override
	public void registerDataSetObserver(DataSetObserver observer) {
		// TODO Auto-generated method stub
		super.registerDataSetObserver(observer);
	}



	/* (non-Javadoc)
	 * @see android.widget.BaseAdapter#unregisterDataSetObserver(android.database.DataSetObserver)
	 */
	@Override
	public void unregisterDataSetObserver(DataSetObserver observer) {
		// TODO Auto-generated method stub
		super.unregisterDataSetObserver(observer);
	}



	public int getCount() {
        return annotations.size();
    }

    public Object getItem(int position) {
    	 
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }
    
    
    @Override
	public boolean isEnabled(int position) {
		// TODO Auto-generated method stub
    	
    	
    	 
		return super.isEnabled(position);
		 
	}



	// create a new ImageView for each item referenced by the Adapter
    public View getView(final int position, View convertView, ViewGroup parent) {
    	
    	//Log.d(this.getClass().getSimpleName(),"getView() - "+position +" ---- " + annotations.get(position).SSID + " ------ " +annotations.get(position).toString());
       
    	
   	 View view = convertView;
   	 	if(convertView==null){
   	 		view = inflater.inflate(R.layout.row_layout_lista_juegos_grid, null);
        }
        
        
   	 	
   	 	
        TextView nombre = (TextView) view.findViewById(R.id.labelNombre);
        
//        TextView sku = (TextView) view.findViewById(R.id.TextViewSKU);
        
        TextView price = (TextView) view.findViewById(R.id.TextViewPrice);

        ImageView LinkES = (ImageView) view.findViewById(R.id.imageViewLinkES);
        ImageView LinkEN = (ImageView) view.findViewById(R.id.ImageViewLinkEN);
         
		TextView Publisher = (TextView) view.findViewById(R.id.textViewPublisher);
		
		
//		final LinearLayout fondo = (LinearLayout) view.findViewById(R.id.LinearLayoutImagenPrecio);
		
		
    	if (annotations == null) {
			
    		//Pintar lista vacia
		      
	  		nombre.setText("");
//	  		sku.setText("");
//	  		hidden.setText("");
	  		
	  		
	  		//Log.w (this.getClass().getSimpleName()," NULL       --- ");
            
	        
		} else {
			//Pintar annotations

//			    	posicion = position;
			    	
			        	
			        	if (annotations.size() == 0){
			        		      
			        		nombre.setText("No hay elementos.");
//			        		sku.setText("");
//			        		hidden.setText("");
			        		
			        	} else {
			        		

			                
			                
			                //Log.w (this.getClass().getSimpleName()," - getView() - "+position +" ---- " + annotations.get(position).SSID + " ------ " +annotations.get(position).toString());
			                
			                if ( annotations.get(position)!=null && (!annotations.get(position).toString().equals(""))) {
			                	
			                	
			                	if ((!annotations.get(position).getConcept().equals(""))) {
						    		//Log.w(this.getClass().getSimpleName()," SSID = "+annotations.get(position).SSID);
						    		nombre.setText(annotations.get(position).getConcept());
								} 
						    	
				                nombre.setText(annotations.get(position).getConcept());
			                	
				                Publisher.setText(annotations.get(position).getGroups().trim()+"  "+annotations.get(position).getSource().trim());
				                
			                
			                
				                LinkES.setOnClickListener(new OnClickListener() {
									
									@Override
									public void onClick(View v) {
										// TODO Auto-generated method stub
										
										
  										if (annotations.get(position).getUrlsp()!=null && !annotations.get(position).getUrlsp().equals("")) {
  											Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(annotations.get(position).getUrlsp()));
      										activity.startActivity(intent);
										} else {
											Toast.makeText(activity.getApplicationContext(), "Url incorrecta:"+annotations.get(position).getUrlsp(), Toast.LENGTH_LONG).show();
										}
  										
										
									}
								});

				                
				                
				                
				                LinkEN.setOnClickListener(new OnClickListener() {
									
      									@Override
      									public void onClick(View v) {
      										// TODO Auto-generated method stub
      										if (annotations.get(position).getUrlen()!=null && !annotations.get(position).getUrlen().equals("")) {
      											Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(annotations.get(position).getUrlen()));
	      										activity.startActivity(intent);
											} else {
												Toast.makeText(activity.getApplicationContext(), "Url incorrecta:"+annotations.get(position).getUrlen(), Toast.LENGTH_LONG).show();
											}
      										
      									}
      								});
				                
				                
				                
			                }
			                
			         		
			        	}  						
		}
    	
           return view;
     
           
    }
    	
    	
    	

    
}

    
      
      
    
    


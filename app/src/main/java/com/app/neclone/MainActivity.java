package com.app.neclone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.app.neclone.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    ArrayList<Fragment> fragmentarrylist = new ArrayList<>();
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


     /*   fragmentarrylist.add(new ExploreFragment());
        fragmentarrylist.add(new ConnectionFragment());
        fragmentarrylist.add(new ChatsFragment());
        fragmentarrylist.add(new ContactsFragment());
        fragmentarrylist.add(new GroupsFragment());


        bottomNavigationView = findViewById(R.id.bottomnav);
*/



        ViewPagerAdapter2 viewPagerAdapter2=new ViewPagerAdapter2(this);
        binding.viewpagertab.setAdapter(viewPagerAdapter2);

        binding.tablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                binding.tablayout.setVisibility(View.VISIBLE);
                binding.viewpagertab.setVisibility(View.VISIBLE);
                binding.frameLayout.setVisibility(View.GONE);
                binding.viewpagertab.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                binding.tablayout.setVisibility(View.VISIBLE);
                binding.viewpagertab.setVisibility(View.VISIBLE);
                binding.frameLayout.setVisibility(View.GONE);
            }
        });
        binding.viewpagertab.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                binding.tablayout.getTabAt(position).select();

                super.onPageSelected(position);
            }
        });



        ExploreFragment exploreFragment=new ExploreFragment();
        ConnectionFragment connectionFragment=new ConnectionFragment();
        ChatsFragment chatsFragment=new ChatsFragment();
        ContactsFragment contactsFragment=new ContactsFragment();
        GroupsFragment groupsFragment=new GroupsFragment();

        binding.tablayout.setVisibility(View.VISIBLE);
        binding.viewpagertab.setVisibility(View.VISIBLE);
        binding.frameLayout.setVisibility(View.GONE);


        binding.bottomnav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int itemId = item.getItemId();
                if (itemId == R.id.explore) {
                    binding.tablayout.setVisibility(View.VISIBLE);
                    binding.viewpagertab.setVisibility(View.VISIBLE);
                    binding.frameLayout.setVisibility(View.GONE);
                   // getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,exploreFragment).commit();
                }else if (itemId == R.id.connections) {
                    binding.tablayout.setVisibility(View.GONE);
                    binding.viewpagertab.setVisibility(View.GONE);
                    binding.frameLayout.setVisibility(View.VISIBLE);
                    getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,connectionFragment).commit();

                } else if (itemId == R.id.chats) {
                    binding.tablayout.setVisibility(View.GONE);
                    binding.viewpagertab.setVisibility(View.GONE);
                    binding.frameLayout.setVisibility(View.VISIBLE);
                    getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,chatsFragment).commit();

                } else if (itemId == R.id.contacts) {
                    binding.tablayout.setVisibility(View.GONE);
                    binding.viewpagertab.setVisibility(View.GONE);
                    binding.frameLayout.setVisibility(View.VISIBLE);
                    getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,contactsFragment).commit();

                }else if (itemId == R.id.groups) {
                    binding.tablayout.setVisibility(View.GONE);
                    binding.viewpagertab.setVisibility(View.GONE);
                    binding.frameLayout.setVisibility(View.VISIBLE);
                    getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,groupsFragment).commit();

                }


                return true;


            }
        });


        binding.progressBar.setProgress(40);
        binding.progressBar.setMax(100);

/*        AdapterViewPager adapterViewPager = new AdapterViewPager(MainActivity.this, fragmentarrylist);
        binding.viewPagerbottom.setAdapter(adapterViewPager);
        binding.viewPagerbottom.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        binding.tablayout.setVisibility(View.VISIBLE);
                        binding.viewpager22.setVisibility(View.VISIBLE);
                        binding.viewPagerbottom.setVisibility(View.GONE);
                        bottomNavigationView.setSelectedItemId(R.id.explore);
                        break;
                    case 1:
                        binding.tablayout.setVisibility(View.GONE);
                        binding.viewpager22.setVisibility(View.GONE);
                        binding.viewPagerbottom.setVisibility(View.VISIBLE);
                        bottomNavigationView.setSelectedItemId(R.id.connections);
                        break;
                    case 2:
                        binding.tablayout.setVisibility(View.GONE);
                        binding.viewpager22.setVisibility(View.GONE);
                        binding.viewPagerbottom.setVisibility(View.VISIBLE);
                        bottomNavigationView.setSelectedItemId(R.id.chats);
                        break;
                    case 3:
                        binding.tablayout.setVisibility(View.GONE);
                        binding.viewpager22.setVisibility(View.GONE);
                        binding.viewPagerbottom.setVisibility(View.VISIBLE);
                        bottomNavigationView.setSelectedItemId(R.id.contacts);
                        break;
                        case 4:
                            binding.tablayout.setVisibility(View.GONE);
                            binding.viewpager22.setVisibility(View.GONE);
                            binding.viewPagerbottom.setVisibility(View.VISIBLE);
                        bottomNavigationView.setSelectedItemId(R.id.groups);
                        break;

                }
                super.onPageSelected(position);
            }
        });

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {



                int itemId = item.getItemId();
                if (itemId == R.id.explore) {
                    binding.tablayout.setVisibility(View.VISIBLE);
                    binding.viewpager22.setVisibility(View.VISIBLE);
                    binding.viewPagerbottom.setVisibility(View.GONE);
                    binding.viewPagerbottom.setCurrentItem(0);
                }else if (itemId == R.id.connections) {
                    binding.tablayout.setVisibility(View.GONE);
                    binding.viewpager22.setVisibility(View.GONE);
                    binding.viewPagerbottom.setVisibility(View.VISIBLE);
                    binding.viewPagerbottom.setCurrentItem(1);

                } else if (itemId == R.id.chats) {
                    binding.tablayout.setVisibility(View.GONE);
                    binding.viewpager22.setVisibility(View.GONE);
                    binding.viewPagerbottom.setVisibility(View.VISIBLE);
                    binding.viewPagerbottom.setCurrentItem(2);

                } else if (itemId == R.id.contacts) {
                    binding.tablayout.setVisibility(View.GONE);
                    binding.viewpager22.setVisibility(View.GONE);
                    binding.viewPagerbottom.setVisibility(View.VISIBLE);
                    binding.viewPagerbottom.setCurrentItem(3);

                }else if (itemId == R.id.groups) {
                    binding.tablayout.setVisibility(View.GONE);
                    binding.viewpager22.setVisibility(View.GONE);
                    binding.viewPagerbottom.setVisibility(View.VISIBLE);
                    binding.viewPagerbottom.setCurrentItem(4);

                }


                return true;
            }
        });*/



        binding.sidebarmainbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.sidebarmain.setVisibility(View.VISIBLE);
                binding.just1.setVisibility(View.VISIBLE);

            }
        });
        binding.just1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.sidebarmain.setVisibility(View.GONE);
                binding.just1.setVisibility(View.GONE);


            }
        });
        binding.refinebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, RefineActivity.class);
                startActivity(intent);
            }
        });
    }
}